package com.arrow.taxi

import com.arrow.utils.SparkService
import org.apache.spark.sql.{Dataset, Encoder, Encoders, SparkSession}

import scala.reflect.runtime.universe.TypeTag

trait TaxiPredictionService extends SparkService with TaxiPredictionInterface {
  def reader[T <: Product: TypeTag](path: String, format: String)(implicit
      encoder: Encoder[T]
  ): Dataset[T] = {
    val supportedFormats = Set("json", "csv", "parquet")
    if (!supportedFormats.contains(format)) {
      throw new IllegalArgumentException(s"Unsupported format: $format")
    }

    spark.read.schema(Encoders.product[T].schema).format(format).load(path).as[T]
  }
}
