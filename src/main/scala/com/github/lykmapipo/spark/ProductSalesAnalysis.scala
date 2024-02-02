package com.github.lykmapipo.spark

import org.apache.spark.{ SparkContext }
import org.apache.spark.sql.{ SparkSession, DataFrame }
import org.apache.spark.sql.{ functions => F }
import org.apache.spark.sql.{ types => T }

import com.github.lykmapipo.spark.analysis.{ AggregationPerCategory, AggregationPerProduct }

object ProductSalesAnalysis {

  def main(args: Array[String]): Unit = {

    // Create a Spark session
    val spark = SparkSession.builder()
      .appName("scala-spark-product-sales-analysis")
      .master("local[*]")
      .getOrCreate()

    // Define product sales schema
    val schema = T.StructType(
      Array(
        T.StructField("ProductName", T.StringType, nullable = false),
        T.StructField("Category", T.StringType, nullable = false),
        T.StructField("Price", T.DoubleType, nullable = false),
        T.StructField("Quantity", T.IntegerType, nullable = false),
        T.StructField("Date", T.DateType, nullable = false),
      )
    )

    // Read product sales input CSV file(s) into a DataFrame
    val inputDF = spark.read
      .schema(schema)
      .option("header", "true")
      .csv("data/raw/*.csv")
      .withColumn("Amount", F.col("Price") * F.col("Quantity"))

    // Run product sales analyses
    AggregationPerProduct.run(inputDF = inputDF)
    AggregationPerCategory.run(inputDF = inputDF)
    // TODO: other analyses

    // Stop the Spark session
    spark.stop()
  }

}