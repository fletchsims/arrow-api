import org.apache.logging.log4j.core.appender.AppenderSet

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.2"

val SparkVersion = "3.3.2"

val akkaHttp = "com.typesafe.akka" %% "akka-http" % "10.2.6"
val akkaStream = "com.typesafe.akka" %% "akka-stream" % "2.6.17"
val uTest = "com.lihaoyi" %% "utest" % "0.7.11" % "test"
val fastTest = "com.github.mrpowers" %% "spark-fast-tests" % "1.1.0" % "test"

val sparkDependencies = Seq(
  "org.apache.spark" %% "spark-core" % SparkVersion,
  "org.apache.spark" %% "spark-sql"  % SparkVersion
)

lazy val root = (project in file("."))
  .aggregate(taxiPredictionApi)
  .settings(
    name := "arrow-api",
    libraryDependencies += fastTest,
    libraryDependencies += uTest,
    libraryDependencies ++= sparkDependencies.map(_ % "provided"),
    assemblyPackageScala / assembleArtifact := false,
    assemblyPackageDependency / assembleArtifact := false
  )

// Apps

lazy val taxiPredictionApi = (project in file("taxi-prediction-api"))
  .settings(
    name := "taxi-prediction-api",
    libraryDependencies += fastTest,
    libraryDependencies += uTest,
    libraryDependencies += akkaHttp,
    libraryDependencies += akkaStream,
    libraryDependencies ++= sparkDependencies.map(_ % "provided"),
    assemblyPackageScala / assembleArtifact := false
  )

