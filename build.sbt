name := "cats-examples"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies += "org.typelevel" %% "cats-core" % "1.0.0"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Ypartial-unification",
  "-language:higherKinds"
)