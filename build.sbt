name := "SV2"

version := "1.0.0-SNAPSHOT"

lazy val `sv2` = (project in file(".")).enablePlugins(PlayScala)

val mysqlConnectorJ = "mysql" % "mysql-connector-java" % "6.0.6"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "org.skinny-framework" %% "skinny-orm" % "2.3.3",
  "org.scalikejdbc" %% "scalikejdbc" % "2.3.1",
  "org.json4s" % "json4s-native_2.11" % "3.4.0",
  mysqlConnectorJ
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

flywaySettings
