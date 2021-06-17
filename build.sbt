import sbt.Keys.libraryDependencies

val scala3Version = "3.0.0-RC3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-terse-notes",
    version := "0.1.0",

    scalaVersion := scala3Version,

    //  https://cloud.google.com/functions/docs/first-java#gradle_1
    libraryDependencies += "com.google.cloud.functions" % "functions-framework-api" % "1.0.1",
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
)
