package com.arrow.model

import java.sql.Timestamp

import org.apache.spark.sql.{Encoder, Encoders}

case class TaxiModel(
                      VendorID: Long,
                      tpep_pickup_datetime: Option[Timestamp],
                      tpep_dropoff_datetime: Option[Timestamp],
                      passenger_count: Option[Double],
                      trip_distance: Option[Double],
                      RatecodeID: Option[Double],
                      store_and_fwd_flag: Option[String],
                      PULocationID: Option[Long],
                      DOLocationID: Option[Long],
                      payment_type: Option[Long],
                      fare_amount: Option[Double],
                      extra: Option[Double],
                      mta_tax: Option[Double],
                      tip_amount: Option[Double],
                      tolls_amount: Option[Double],
                      improvement_surcharge: Option[Double],
                      total_amount: Option[Double],
                      congestion_surcharge: Option[Double],
                      airport_fee: Option[Double]
                    )

