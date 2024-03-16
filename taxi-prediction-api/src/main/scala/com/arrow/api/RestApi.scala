package com.arrow.api

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.Materializer
import scala.io.StdIn

object RestApi {
  implicit val system = ActorSystem("rest-api")
  implicit val executionContext = system.dispatcher
}
