# Scala-Spark-Product-Sales-Analysis

Scala application to process, and analyze product sales files using Spark.

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

- To perform `product sales analysis`, run:
```sh
sbt run
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

- Check [data/analyses/aggregate-sales-per-category](https://github.com/lykmapipo/Scala-Spark-Product-Sales-Analysis/tree/main/data/analyses/aggregate-sales-per-category) directory for `output` data generated when run `sbt run`. Each file is in `csv format`, and each entry follow below `spark` schema:

```sh
root
 |-- Category: string (nullable = true)
 |-- TotalSalesQuantity: long (nullable = true)
 |-- TotalSalesAmount: double (nullable = true)
 |-- AverageSalesAmount: double (nullable = true)
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
