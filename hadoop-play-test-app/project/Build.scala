import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "hadoop-play"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
            "org.apache.hadoop" % "hadoop-core" % "1.0.3",
            "org.apache.hadoop" % "hadoop-streaming" % "1.0.3",
            "junit" % "junit" % "4.10" % "test",
            "org.hamcrest" % "hamcrest-all" % "1.1",
            "org.apache.mrunit" % "mrunit" % "0.8.0-incubating" % "test",
            "commons-io" % "commons-io" % "2.4",
            "org.apache.hadoop" % "hadoop-test" % "1.0.3" % "test",
            "org.apache.mrunit" % "mrunit" % "0.8.1-incubating" % "test",
            "com.sun.jersey" % "jersey-core" % "1.8" % "test"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
