val scala3Version = "3.1.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-word-counter",
    version := "0.5.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % "test"
  )
