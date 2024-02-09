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
- Check [DATA.md](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/DATA.md) for description of `raw data` used and `output data` of each analysis.


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
