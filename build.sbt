import sbt.Keys.testFrameworks

ThisBuild / scalaVersion     := "2.13.3"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "dev.ligature"
ThisBuild / organizationName := "Ligature"

resolvers += Resolver.mavenLocal

mainClass in (Compile, run) := Some("dev.ligature.server.LigatureServer")
mainClass in (Compile, packageBin) := Some("dev.ligature.server.LigatureServer")

lazy val root = (project in file("."))
  .settings(
    name := "ligature-server",
    libraryDependencies += "dev.ligature" %% "ligature-mock" % "0.1.0-SNAPSHOT",
    libraryDependencies += "io.vertx" % "vertx-web" % "3.9.4",
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.16" % Test,
    testFrameworks += new TestFramework("munit.Framework")
  )
