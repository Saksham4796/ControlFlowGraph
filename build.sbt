lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.13.6"
    )),
    name := "scalatest-example"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test

libraryDependencies += "ca.mcgill.sable" % "soot" % "4.1.0"

libraryDependencies += "com.github.scopt" % "scopt_2.13" % "4.0.0-RC2" % "compile"

libraryDependencies += "com.github.pathikrit" % "better-files_2.13" % "3.9.1"

libraryDependencies += "org.scala-graph" % "graph-core_2.13" % "1.13.5"

libraryDependencies ++= {
  Seq("org.slf4j" % "slf4j-log4j12" % "1.7.30")
}.map(_.force())