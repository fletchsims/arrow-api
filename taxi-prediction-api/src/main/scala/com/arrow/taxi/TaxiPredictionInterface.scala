package com.arrow.taxi

import org.apache.spark.sql.{Dataset, Encoder}

import scala.reflect.runtime.universe.TypeTag

trait TaxiPredictionInterface {
  this: TaxiPredictionService =>
  def reader[T <: Product : TypeTag](path: String, format: String)(implicit encoder: Encoder[T]): Dataset[T]
}
