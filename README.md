# scala-util
This project includes some utilities for Scala.

## SQL Util

### Using JdbcHelper as the Hive Client

* Copy Hive client JAR files to $SCALE_HOME/lib. The following includes some JARs for Hive 0.12

JAR Files | JAR Files 
------------ | -------------
commons-httpclient-3.0.1.jar | commons-logging-1.1.3.jar
hadoop-common-2.0.0-cdh4.6.0.jar | hadoop-core-2.0.0-mr1-cdh4.6.0.jar
hive-exec-0.12.0-cdh5.1.4.jar | hive-jdbc-0.12.0-cdh5.1.4.jar
hive-metastore-0.12.0-cdh5.1.4.jar | hive-service-0.12.0-cdh5.1.4.jar
httpclient-4.2.5.jar | httpcore-4.2.5.jar
libfb303-0.9.0.jar | log4j-1.2.16.jar
slf4j-api-1.7.5.jar | slf4j-log4j12-1.7.5.jar

* Start the scala shell and load JdbcHelper.scala
* Reference the [Test code](https://github.com/leoricklin/scala-util/blob/2.10.4/src/test/scala/tw/com/chttl/scala/sql/util/JdbcHelperTest.scala)


