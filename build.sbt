ThisBuild / scalaVersion     := "2.13.10"
ThisBuild / organization     := "io.adamnfish"
ThisBuild / organizationName := "adamnfish"

lazy val root = (project in file("."))
  .settings(
    name := "preinterview",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.16" % "test"
    )
  )
