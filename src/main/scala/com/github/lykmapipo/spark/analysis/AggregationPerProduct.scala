package com.github.lykmapipo.spark.analysis

import org.apache.spark.sql.{DataFrame}
import org.apache.spark.sql.{functions => F}

object AggregationPerProduct {

  def run(inputDF: DataFrame): Unit = {

    println("Start: Calculate sales aggregation per product")

    // Calculate sales aggregation per product
    val analysisDF = inputDF
      .groupBy(F.col("ProductName"))
      .agg(
        F.sum(F.col("Quantity")).as("TotalSalesQuantity"),
        F.sum(F.col("Amount")).as("TotalSalesAmount")
      )
      .withColumn(
        "AverageSellingPrice",
        F.col("TotalSalesAmount") / F.col("TotalSalesQuantity")
      )
      .orderBy(F.col("TotalSalesAmount").desc)

    // Write analysis results
    analysisDF.write
      .mode("overwrite")
      .option("header", "true")
      .csv("data/analyses/aggregate-sales-per-product")

    println("Finish: Calculate sales aggregation per product")

  }

}
