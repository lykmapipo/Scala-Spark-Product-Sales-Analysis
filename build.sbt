name := "scala-spark-product-sales-analysis"
organization := "com.github.lykmapipo"
version := "0.1.0"

scalaVersion := "2.13.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.5.0" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.5.0"

fork := true

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x                             => MergeStrategy.first
}
