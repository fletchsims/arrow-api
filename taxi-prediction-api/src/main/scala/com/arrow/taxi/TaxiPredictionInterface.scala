package com.arrow.taxi

import org.apache.spark.sql.Dataset

trait TaxiPredictionInterface {
  this: TaxiPredictionService =>
  def reader(path: String, format: String): Dataset[_]
}
