package com.github.lykmapipo.spark

import org.apache.spark.{ SparkContext }
import org.apache.spark.sql.{ SparkSession, DataFrame }
import org.apache.spark.sql.{ functions => F }
import org.apache.spark.sql.{ types => T }

object ProductSalesAnalysis {
  def main(args: Array[String]): Unit = {

    // Create a Spark session
    val spark = SparkSession.builder()
      .appName("scala-spark-product-sales-analysis")
      .master("local[*]")
      .getOrCreate()

    // Read product sales input CSV file(s) into a DataFrame
    val inputPath = "data/raw/*.csv"
    val rawDF = spark.read.option("header", "true").csv(inputPath)

    // Cast input sales entries into their respective data types
    val inputDF = rawDF.select(
      F.col("ProductName").alias("ProductName").cast(T.StringType),
      F.col("Category").alias("Category").cast(T.StringType),
      F.col("Price").alias("Price").cast(T.DoubleType),
      F.col("Quantity").alias("Quantity").cast(T.IntegerType),
      F.col("Date").alias("Date").cast(T.DateType),
    )

    // Calculate sales aggregation per category
    val analysisDF = inputDF
      .withColumn("Amount", F.col("Price") * F.col("Quantity"))
      .groupBy(F.col("Category"))
      .agg(
        F.sum(F.col("Quantity")).as("TotalSalesQuantity"),
        F.sum(F.col("Amount")).as("TotalSalesAmount"),
        F.avg(F.col("Amount")).as("AverageSalesAmount"),
       )

    // Write analyses results
    analysisDF.printSchema()
    val outputPath = "data/analyses/aggregate-sales-per-category"
    analysisDF.coalesce(1).write.mode("overwrite").option("header", "true").csv(outputPath)

    // Stop the Spark session
    spark.stop()
  }

}