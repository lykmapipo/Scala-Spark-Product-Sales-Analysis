package com.github.lykmapipo.spark.analysis

import org.apache.spark.sql.{DataFrame}
import org.apache.spark.sql.{functions => F}

object AggregationOverall {

  def run(inputDF: DataFrame): Unit = {

    println("Start: Calculate sales overall aggregation")

    // Calculate sales overall aggregation
    val analysisDF = inputDF
      .agg(
        F.sum(F.col("Quantity")).as("TotalSalesQuantity"),
        F.sum(F.col("Amount")).as("TotalSalesAmount"),
        F.countDistinct(F.col("Date")).as("TotalSalesDay")
      )

    // Write analysis results
    analysisDF.write
      .mode("overwrite")
      .option("header", "true")
      .csv("data/analyses/aggregate-overall")

    println("Finish: Calculate sales overall aggregation")

  }

}
