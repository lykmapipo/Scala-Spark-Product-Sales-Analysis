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

    // Calculate sales overall running totals
    val analysisDF = inputDF
      .select(
        F.col("Date").as("Date"),
        F.col("Quantity").as("Quantity"),
        F.col("Amount").as("Amount"),
        F.sum(F.col("Quantity"))
          .over(windowSpec)
          .as("RunningTotalSalesQuantity"),
        F.sum(F.col("Amount")).over(windowSpec).as("RunningTotalSalesAmount")
      )

    // Write analysis results
    analysisDF.write
      .mode("overwrite")
      .option("header", "true")
      .csv("data/analyses/running-total-overall")

    println("Finish: Calculate sales overall running totals")

  }

}
