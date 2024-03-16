package com.arrow.taxi

import com.arrow.utils.SparkService
import org.apache.spark.sql.Dataset

trait TaxiPredictionService extends SparkService {
  def reader(path: String, format: String): Dataset[_] = {
    val supportedFormats = Set("json", "csv", "parquet")
    if (!supportedFormats.contains(format)) {
      throw new IllegalArgumentException(s"Unsupported format: $format")
    }

    val reader = spark.read.format(format)
    val data = reader.load(path)
    data
  }
}
