package com.arrow.taxi

import com.arrow.utils.SparkService

object TaxiPredictionDriver extends SparkService {
  def main(args: Array[String]) = {
    import spark.implicits._
    val taxi = spark.read.parquet("./data/taxi/yellow_tripdata_2023-01.parquet")
    taxi.printSchema()
    taxi.show(333, false)
  }
}
