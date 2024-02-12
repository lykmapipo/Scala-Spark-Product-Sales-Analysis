package com.github.lykmapipo.spark.analysis

import org.apache.spark.sql.{DataFrame}
import org.apache.spark.sql.expressions.{Window}
import org.apache.spark.sql.{functions => F}

object RollingAveragePerCategory {

  def run(inputDF: DataFrame): Unit = {

    println("Start: Calculate sales rolling averages per category")

    // Define the window specifications for rolling averages per category
    // Assuming a 7-day rolling average (window size = 7)
    val windowSpec = Window
      .partitionBy(F.col("Category"))
      .orderBy(F.col("Date"))
      .rowsBetween(-6, 0)

    // Handle repetitive dates by aggregating data for each unique date
    // and category
    val aggregatedInputDF = inputDF
      .groupBy(F.col("Date"), F.col("Category"))
      .agg(
        F.sum(F.col("Quantity")).as("TotalSalesQuantity"),
        F.sum(F.col("Amount")).as("TotalSalesAmount")
      )

    // Calculate sales rolling averages per category
    val analysisDF = aggregatedInputDF
      .select(
        F.col("Date").as("Date"),
        F.col("Category").as("Category"),
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
      .partitionBy("Category")
      .csv("data/analyses/rolling-average-per-category")

    println("Finish: Calculate sales rolling averages per category")

  }

}
