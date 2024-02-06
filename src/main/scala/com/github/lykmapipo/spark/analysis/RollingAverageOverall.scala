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

    // Calculate sales overall rolling averages
    val analysisDF = inputDF
      .select(
        F.col("Date").as("Date"),
        F.col("Quantity").as("Quantity"),
        F.col("Amount").as("Amount"),
        F.avg(F.col("Quantity"))
          .over(windowSpec)
          .as("RollingAverageSalesQuantity"),
        F.avg(F.col("Amount")).over(windowSpec).as("RollingAverageSalesAmount")
      )

    // Write analysis results
    analysisDF.write
      .mode("overwrite")
      .option("header", "true")
      .csv("data/analyses/rolling-average-overall")

    println("Finish: Calculate sales overall rolling averages")

  }

}
