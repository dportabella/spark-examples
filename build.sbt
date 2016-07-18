val sparkVersion = "1.6.1"
val hbaseVersion = "1.2.2"

name := "spark-examples"

version := sparkVersion

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

initialize := {
  val _ = initialize.value
  if (sys.props("java.specification.version") != "1.8")
    sys.error("Java 8 is required for this project.")
}

scalaVersion := "2.10.6"

// for hbase 1.2.2 until it is published to maven. See https://issues.apache.org/jira/browse/HBASE-15925
resolvers += "Apache Staging" at "https://repository.apache.org/content/repositories/orgapachehbase-1142/"

libraryDependencies ++= Seq(
  "javax.servlet" % "javax.servlet-api" % "3.1.0",
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-bagel" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "org.apache.spark" %% "spark-graphx" % sparkVersion,
  "org.apache.spark" %% "spark-streaming-twitter" % sparkVersion,
  "org.apache.spark" %% "spark-streaming-flume" % sparkVersion,
  "org.apache.spark" %% "spark-streaming-mqtt" % sparkVersion,
  "org.apache.spark" %% "spark-streaming-zeromq" % sparkVersion
     exclude("org.spark-project.protobuf", "protobuf-java"),
  "org.apache.spark" %% "spark-streaming-kafka" % sparkVersion,
  "org.apache.hbase" % "hbase-testing-util" % hbaseVersion
     exclude("org.apache.hbase", "hbase-annotations")
     exclude("org.jruby", "jruby-complete"),
  "org.apache.hbase" % "hbase-protocol" % hbaseVersion,
  "org.apache.hbase" % "hbase-common" % hbaseVersion
     exclude("org.apache.hbase", "hbase-annotations"),
  "org.apache.hbase" % "hbase-client" % hbaseVersion
     exclude("org.apache.hbase", "hbase-annotations")
     exclude("io.netty", "netty"),
  "org.apache.hbase" % "hbase-server" % hbaseVersion
     exclude("org.apache.hbase", "hbase-annotations")
     exclude("org.apache.hadoop", "hadoop-core")
     exclude("org.apache.hadoop", "hadoop-client")
     exclude("org.apache.hadoop", "hadoop-mapreduce-client-jobclient")
     exclude("org.apache.hadoop", "hadoop-mapreduce-client-core")
     exclude("org.apache.hadoop", "hadoop-auth")
     exclude("org.apache.hadoop", "hadoop-annotations")
     exclude("org.apache.hadoop", "hadoop-hdfs")
     exclude("org.apache.hbase", "hbase-hadoop1-compat")
     exclude("org.apache.commons", "commons-math")
     exclude("com.sun.jersey", "jersey-core")
     exclude("org.slf4j", "slf4j-api")
     exclude("com.sun.jersey", "jersey-server")
     exclude("com.sun.jersey", "jersey-core")
     exclude("com.sun.jersey", "jersey-json")
     exclude("commons-io", "commons-io")
     exclude("javax.servlet", "servlet-api"),
  "org.apache.hbase" % "hbase-hadoop-compat" % hbaseVersion,
  "org.apache.commons" % "commons-math3" % "3.6.1",
  "com.twitter" %% "algebird-core" % "0.9.0",
  "org.scalacheck" %% "scalacheck" % "1.13.1",
  "org.apache.cassandra" % "cassandra-all" % "1.2.6"
     exclude("com.google.guava", "guava")
     exclude("com.googlecode.concurrentlinkedhashmap", "concurrentlinkedhashmap-lru")
     exclude("com.ning", "compress-lzf")
     exclude("commons-cli", "commons-cli")
     exclude("commons-codec", "commons-codec")
     exclude("commons-lang", "commons-lang")
     exclude("commons-logging", "commons-logging")
     exclude("io.netty", "netty")
     exclude("jline", "jline")
     exclude("net.jpountz.lz4", "lz4")
     exclude("org.apache.cassandra.deps", "avro")
     exclude("org.apache.commons", "commons-math3")
     exclude("org.apache.thrift", "libthrift"),
  "com.github.scopt" %% "scopt" % "3.2.0",
  "org.apache.spark" %% "spark-streaming-kinesis-asl" % sparkVersion,
  "org.eclipse.paho" % "org.eclipse.paho.client.mqttv3" % "1.0.2"
)
