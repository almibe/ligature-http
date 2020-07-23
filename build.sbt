import Dependencies._

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "dev.ligature"
ThisBuild / organizationName := "Ligature"

resolvers += Resolver.mavenLocal

lazy val root = (project in file("."))
  .settings(
    name := "ligature-lab",
    libraryDependencies += "dev.ligature" %% "ligature-rocksdb" % "0.1.0-SNAPSHOT",
    libraryDependencies += "io.vertx" % "vertx-web" % "3.9.1",
    libraryDependencies += scalaTest % Test
  )
