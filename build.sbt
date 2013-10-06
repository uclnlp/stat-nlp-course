name := "statnlp"

organization := "uk.ac.ucl.cs.mr"

// The := method used in Name and Version is one of two fundamental methods.
// The other method is <<=
// All other initialization methods are implemented in terms of these.
//version := "0.1-SNAPSHOT"

//crossScalaVersions := Seq("2.9.1", "2.9.2","2.10.0")

scalaVersion := "2.10.2"

resolvers ++= Seq(
    "IESL third party" at "https://dev-iesl.cs.umass.edu/nexus/content/repositories/thirdparty/",
    "IESL snapshots" at "https://dev-iesl.cs.umass.edu/nexus/content/repositories/snapshots",
    "IESL releases" at "https://dev-iesl.cs.umass.edu/nexus/content/repositories/releases"
)


scalacOptions ++= Seq("-unchecked","-deprecation")

