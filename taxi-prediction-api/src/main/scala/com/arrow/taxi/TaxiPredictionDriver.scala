package com.arrow.taxi

import com.arrow.model.TaxiModel
import com.arrow.utils.SparkService
import org.apache.spark.sql.{Encoder, Encoders}

object TaxiPredictionDriver extends SparkService with TaxiPredictionService {
  def main(args: Array[String]) = {
    implicit val taxiModelEncoder: Encoder[TaxiModel] = Encoders.product[TaxiModel]
    val taxi = reader[TaxiModel]("./data/taxi/yellow_tripdata_2023-01.parquet", "parquet")
    taxi.printSchema()
    taxi.show(33, false)
  }
}
