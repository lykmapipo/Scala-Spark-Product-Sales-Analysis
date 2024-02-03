package com.github.lykmapipo.spark.analysis

import org.apache.spark.sql.{DataFrame}
import org.apache.spark.sql.{functions => F}

object AggregationPerDate {

  def run(inputDF: DataFrame): Unit = {

    println("Start: Calculate sales aggregation per date")

    // Calculate sales aggregation per date
    val analysisDF = inputDF
      .groupBy(F.col("Date"))
      .agg(
        F.sum(F.col("Quantity")).as("TotalSalesQuantity"),
        F.sum(F.col("Amount")).as("TotalSalesAmount")
      )
      .orderBy(F.col("TotalSalesAmount").desc)

    // Write analysis results
    analysisDF.write
      .mode("overwrite")
      .option("header", "true")
      .csv("data/analyses/aggregate-sales-per-date")

    println("Finish: Calculate sales aggregation per date")

  }

}
