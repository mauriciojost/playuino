import play.sbt.PlayImport._

name := """scala-play-rest-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test
)

libraryDependencies += "org.mockito" % "mockito-core" % "1.9.5" % "test"
