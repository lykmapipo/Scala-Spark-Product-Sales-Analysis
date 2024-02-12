package com.github.lykmapipo.spark.analysis

import org.apache.spark.sql.{DataFrame}
import org.apache.spark.sql.expressions.{Window}
import org.apache.spark.sql.{functions => F}

object RunningTotalPerCategory {

  def run(inputDF: DataFrame): Unit = {

    println("Start: Calculate sales running totals per category")

    // Define the window specifications for running totals per category
    val windowSpec = Window
      .partitionBy(F.col("Category"))
      .orderBy(F.col("Date"))
      .rowsBetween(Window.unboundedPreceding, 0)

    // Handle repetitive dates by aggregating data for each unique date
    // and category
    val aggregatedInputDF = inputDF
      .groupBy(F.col("Date"), F.col("Category"))
      .agg(
        F.sum(F.col("Quantity")).as("TotalSalesQuantity"),
        F.sum(F.col("Amount")).as("TotalSalesAmount")
      )

    // Calculate sales running totals per category
    val analysisDF = aggregatedInputDF
      .select(
        F.col("Date").as("Date"),
        F.col("Category").as("Category"),
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
      .partitionBy("Category")
      .csv("data/analyses/running-total-per-category")

    println("Finish: Calculate sales running totals per category")

  }

}
