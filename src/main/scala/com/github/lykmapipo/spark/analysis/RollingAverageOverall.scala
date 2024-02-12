package com.github.lykmapipo.spark.analysis

import org.apache.spark.sql.{DataFrame}
import org.apache.spark.sql.expressions.{Window}
import org.apache.spark.sql.{functions => F}

object RollingAverageOverall {

  def run(inputDF: DataFrame): Unit = {

    println("Start: Calculate sales overall rolling averages")

    // Define the window specifications for rolling averages
    // Assuming a 7-day rolling average (window size = 7)
    val windowSpec = Window
      .orderBy(F.col("Date"))
      .rowsBetween(-6, 0)

    // Handle repetitive dates by aggregating data for each unique date
    val aggregatedInputDF = inputDF
      .groupBy(F.col("Date"))
      .agg(
        F.sum(F.col("Quantity")).as("TotalSalesQuantity"),
        F.sum(F.col("Amount")).as("TotalSalesAmount")
      )

    // Calculate sales overall rolling averages
    val analysisDF = aggregatedInputDF
      .select(
        F.col("Date").as("Date"),
        F.col("TotalSalesQuantity").as("TotalSalesQuantity"),
        F.col("TotalSalesAmount").as("TotalSalesAmount"),
        F.avg(F.col("TotalSalesQuantity"))
          .over(windowSpec)
          .as("RollingAverageSalesQuantity"),
        F.avg(F.col("TotalSalesAmount"))
          .over(windowSpec)
          .as("RollingAverageSalesAmount")
      )

    // Write analysis results
    analysisDF.write
      .mode("overwrite")
      .option("header", "true")
      .csv("data/analyses/rolling-average-overall")

    println("Finish: Calculate sales overall rolling averages")

  }

}
