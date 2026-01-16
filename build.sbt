name := "basic-spark-jar"
version := "1.0.0"

// Spark provided by Databricks
scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "4.0.0" % "provided"
)

// Assembly settings
assembly / mainClass := Some("MainApp")
assembly / assemblyJarName := "basic-spark-jar.jar"