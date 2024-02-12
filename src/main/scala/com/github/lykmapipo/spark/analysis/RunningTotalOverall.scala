package com.github.lykmapipo.spark.analysis

import org.apache.spark.sql.{DataFrame}
import org.apache.spark.sql.expressions.{Window}
import org.apache.spark.sql.{functions => F}

object RunningTotalOverall {

  def run(inputDF: DataFrame): Unit = {

    println("Start: Calculate sales overall running totals")

    // Define the window specifications for running totals
    val windowSpec = Window
      .orderBy(F.col("Date"))
      .rowsBetween(Window.unboundedPreceding, 0)

    // Handle repetitive dates by aggregating data for each unique date
    val aggregatedInputDF = inputDF
      .groupBy(F.col("Date"))
      .agg(
        F.sum(F.col("Quantity")).as("TotalSalesQuantity"),
        F.sum(F.col("Amount")).as("TotalSalesAmount")
      )

    // Calculate sales overall running totals
    val analysisDF = aggregatedInputDF
      .select(
        F.col("Date").as("Date"),
        F.col("TotalSalesQuantity").as("TotalSalesQuantity"),
        F.col("TotalSalesAmount").as("TotalSalesAmount"),
        F.sum(F.col("TotalSalesQuantity"))
          .over(windowSpec)
          .as("RunningTotalSalesQuantity"),
        F.sum(F.col("TotalSalesAmount"))
          .over(windowSpec)
          .as("RunningTotalSalesAmount")
      )

    // Write analysis results
    analysisDF.write
      .mode("overwrite")
      .option("header", "true")
      .csv("data/analyses/running-total-overall")

    println("Finish: Calculate sales overall running totals")

  }

}
