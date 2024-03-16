package com.arrow.taxi

import com.arrow.utils.SparkService

object TaxiPredictionDriver extends SparkService with TaxiPredictionService {
  def main(args: Array[String]) = {
    import spark.implicits._
    val taxi = reader("./data/taxi/yellow_tripdata_2023-01.parquet", "parquet")
    taxi.printSchema()
    taxi.show(333, false)
  }
}
