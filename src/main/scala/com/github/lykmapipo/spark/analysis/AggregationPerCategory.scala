package com.github.lykmapipo.spark.analysis

import org.apache.spark.sql.{DataFrame}
import org.apache.spark.sql.{functions => F}

object AggregationPerCategory {

  def run(inputDF: DataFrame): Unit = {

    println("Start: Calculate sales aggregation per category")

    // Calculate sales aggregation per category
    val analysisDF = inputDF
      .groupBy(F.col("Category"))
      .agg(
        F.sum(F.col("Quantity")).as("TotalSalesQuantity"),
        F.sum(F.col("Amount")).as("TotalSalesAmount"),
        F.avg(F.col("Amount")).as("AverageSalesAmount")
      )
      .orderBy(F.col("TotalSalesAmount").desc)

    // Write analysis results
    analysisDF.write
      .mode("overwrite")
      .option("header", "true")
      .csv("data/analyses/aggregate-sales-per-category")

    println("Finish: Calculate sales aggregation per category")

  }

}
