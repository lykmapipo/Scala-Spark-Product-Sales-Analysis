# Data


## Raw

- Check [data/raw](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/raw) directory for all `raw product sales` data. Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- ProductName: string (nullable = true)
 |-- Category: string (nullable = true)
 |-- Price: double (nullable = true)
 |-- Quantity: integer (nullable = true)
 |-- Date: date (nullable = true)
```


## Aggregation

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


## Running Total

- Check [data/analyses/running-total-overall](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/analyses/running-total-overall) directory for `output` data generated when run [RunningTotalOverall.scala](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/RunningTotalOverall.scala) analysis. Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- Date: date (nullable = true)
 |-- Quantity: integer (nullable = true)
 |-- Amount: double (nullable = true)
 |-- RunningTotalSalesQuantity: long (nullable = true)
 |-- RunningTotalSalesAmount: double (nullable = true)
```

- Check [data/analyses/running-total-per-category](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/analyses/running-total-per-category) directory for `output` data generated when run [RunningTotalPerCategory.scala](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/RunningTotalPerCategory.scala) analysis. Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- Date: date (nullable = true)
 |-- Quantity: integer (nullable = true)
 |-- Amount: double (nullable = true)
 |-- RunningTotalSalesQuantity: long (nullable = true)
 |-- RunningTotalSalesAmount: double (nullable = true)
```


## Rolling Average

- Check [data/analyses/rolling-average-overall](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/analyses/rolling-average-overall) directory for `output` data generated when run [RollingAverageOverall.scala](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/RollingAverageOverall.scala) analysis. Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- Date: date (nullable = true)
 |-- Quantity: integer (nullable = true)
 |-- Amount: double (nullable = true)
 |-- RollingAverageSalesQuantity: double (nullable = true)
 |-- RollingAverageSalesAmount: double (nullable = true)
```

- Check [data/analyses/rolling-average-per-category](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/analyses/rolling-average-per-category) directory for `output` data generated when run [RollingAveragePerCategory.scala](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/blob/main/src/main/scala/com/github/lykmapipo/spark/analysis/RollingAveragePerCategory.scala) analysis. Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- Date: date (nullable = true)
 |-- Quantity: integer (nullable = true)
 |-- Amount: double (nullable = true)
 |-- RollingAverageSalesQuantity: double (nullable = true)
 |-- RollingAverageSalesAmount: double (nullable = true)
```