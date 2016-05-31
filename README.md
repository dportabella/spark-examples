# spark-examples

this project is a copy of the spark examples (`data` and `examples/src`) from the official spark distribution:
https://github.com/apache/spark/blob/v1.6.1

the build.sbt has been adapted from the pom.xml, and includes a fix for:
- a missing dependency org.eclipse.paho.client.mqttv3:1.0.1
- a dependency exclusion for a conflict on different versions of jetty/servlet-api imported by hbase-server which makes IntelliJ fail.

build and run the examaples from the shell or IntelliJ:

```$ sbt -Dspark.master=local[2] run```
