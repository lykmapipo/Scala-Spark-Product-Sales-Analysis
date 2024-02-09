# Scala-Spark-Product-Sales-Analysis

Scala application to process, and analyze product sales using Apache Spark.

These include:

1. Aggregations: [Overall](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/AggregationOverall.scala), [Per Category](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/AggregationPerCategory.scala), [Per Date](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/AggregationPerDate.scala), [Per Product](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/AggregationPerProduct.scala)

2. Running Totals: [Overall](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/RunningTotalOverall.scala), [Per Category](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/RunningTotalPerCategory.scala)

3. Rolling Averages: [Overall](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/RollingAverageOverall.scala), [Per Category](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/RollingAveragePerCategory.scala)


> 👋 This repository's maintainer is available to hire for Scala/Spark consulting projects. To get a cost estimate, send email to lallyelias87@gmail.com (for projects of any size or complexity).


## Requirements

- [Java 11+](https://github.com/openjdk/jdk)
- [Scala 2.13.10+](https://github.com/scala/scala)
- [sbt 1.8.2+](https://github.com/sbt/sbt)
- [Apache Spark 3.5+](https://github.com/apache/spark)


## Usage

- Clone this repository
```sh
git clone https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis.git
cd Scala-Spark-Product-Sales-Analysis
```

- To perform `product sales analysis` with `sbt`, run:
```sh
sbt run
```

- To perform `product sales analysis` with `spark-submit`, run:
```sh
sbt assembly

spark-submit \
     --class com.github.lykmapipo.spark.ProductSalesAnalysis \
     --master <your_spark_master> \
     target/scala-2.13/scala-spark-product-sales-analysis-assembly-0.1.0.jar
```


## Data
- Check [data/raw](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/raw) directory for all `raw product sales` data. Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- ProductName: string (nullable = true)
 |-- Category: string (nullable = true)
 |-- Price: double (nullable = true)
 |-- Quantity: integer (nullable = true)
 |-- Date: date (nullable = true)
```

- Check [data/analyses/aggregate-overall](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/analyses/aggregate-overall) directory for `output` data generated when run [AggregationOverall.scala](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/AggregationOverall.scala) analysis. Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- TotalSalesQuantity: long (nullable = true)
 |-- TotalSalesAmount: double (nullable = true)
 |-- TotalSalesDay: long (nullable = false)
```

- Check [data/analyses/aggregate-sales-per-category](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/analyses/aggregate-sales-per-category) directory for `output` data generated when run [AggregationPerCategory.scala](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/AggregationPerCategory.scala) analysis. Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- Category: string (nullable = true)
 |-- TotalSalesQuantity: long (nullable = true)
 |-- TotalSalesAmount: double (nullable = true)
```

- Check [data/analyses/aggregate-sales-per-date](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/analyses/aggregate-sales-per-date) directory for `output` data generated when run [AggregationPerDate.scala](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/AggregationPerDate.scala). Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- Date: date (nullable = true)
 |-- TotalSalesQuantity: long (nullable = true)
 |-- TotalSalesAmount: double (nullable = true)
```

- Check [data/analyses/aggregate-sales-per-product](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/analyses/aggregate-sales-per-product) directory for `output` data generated when run [AggregationPerProduct.scala](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/AggregationPerProduct.scala). Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- ProductName: string (nullable = true)
 |-- TotalSalesQuantity: long (nullable = true)
 |-- TotalSalesAmount: double (nullable = true)
 |-- AverageSellingPrice: double (nullable = true)
```

- Check [data/analyses/running-total-overall](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/analyses/running-total-overall) directory for `output` data generated when run [RunningTotalOverall.scala](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/RunningTotalOverall.scala) analysis. Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- Date: date (nullable = true)
 |-- Quantity: integer (nullable = true)
 |-- Amount: double (nullable = true)
 |-- RunningTotalSalesQuantity: long (nullable = true)
 |-- RunningTotalSalesAmount: double (nullable = true)
```

- Check [data/analyses/rolling-average-overall](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/analyses/rolling-average-overall) directory for `output` data generated when run [RollingAverageOverall.scala](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/RollingAverageOverall.scala) analysis. Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- Date: date (nullable = true)
 |-- Quantity: integer (nullable = true)
 |-- Amount: double (nullable = true)
 |-- RollingAverageSalesQuantity: double (nullable = true)
 |-- RollingAverageSalesAmount: double (nullable = true)
```


## Contribute

It will be nice, if you open an issue first so that we can know what is going on, then, fork this repo and push in your ideas.


## Questions/Issues/Contacts

lallyelias87@gmail.com, or open a GitHub issue


## Licence

The MIT License (MIT)

Copyright (c) lykmapipo & Contributors

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
