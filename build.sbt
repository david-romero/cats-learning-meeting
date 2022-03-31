name := "learning-meeting"

version := "0.1"

scalaVersion := "2.13.7"

libraryDependencies ++= Seq(
 "org.typelevel"                %% "cats-core"            % "2.7.0",
 "org.typelevel"                %% "cats-effect"          % "3.3.9",
  "org.scalatest"       %% "scalatest"               % "3.2.11"      % "test, it"
)
