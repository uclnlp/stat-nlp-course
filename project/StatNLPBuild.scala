import java.io.IOException
import sbt._
import sbt.Keys._
import sbtrelease.ReleasePlugin._
import scoverage.ScoverageSbtPlugin._

object ShellPrompt {
  object devnull extends ProcessLogger {
    def info(s: => String) {}
    def error(s: => String) {}
    def buffer[T](f: => T): T = f
  }
  def currBranch = {
    try {
      (
      ("git status -sb" lines_! devnull headOption)
      getOrElse "-" stripPrefix "## "
      )
    } catch {
      case ex: IOException => "?"
    }
  }

  val buildShellPrompt = {
    (state: State) => {
      val extracted = Project.extract(state)
      val currProject = extracted.currentProject.id
      "%s:%s:%s> ".format(
        currProject, currBranch, extracted.get(version)
      )
    }
  }
}

object BuildSettings {
  val buildName         = "statnlp"
  val buildOrganization = "uk.ac.ucl.cs.mr"
  val buildScalaVersion = "2.10.2"

  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := buildOrganization,
    scalaVersion := buildScalaVersion,
    scalacOptions := Seq("-unchecked", "-deprecation", "-feature"), //, "-Yrangepos"?
    shellPrompt := ShellPrompt.buildShellPrompt,
    fork in run := true //use a fresh JVM for sbt run
  )

  val globalDependencies = libraryDependencies ++= Seq(
    "org.scalautils" % "scalautils_2.10" % "2.0",
    "org.scalatest" %% "scalatest" % "2.1.0" % "test",
    "org.json4s" %% "json4s-native" % "3.2.10",
    "ml.wolfe" %% "wolfe-core" % "0.4.0-SNAPSHOT",
    "ml.wolfe" %% "wolfe-nlp" % "0.4.0-SNAPSHOT",
    "ml.wolfe" %% "wolfe-examples" % "0.4.0-SNAPSHOT",
    "ml.wolfe" %% "wolfe-util" % "0.4.0-SNAPSHOT"
    //"org.riedelcastro.frontlets" %% "frontlets" % "0.6.0-SNAPSHOT"
  )

  val coreDependencies = libraryDependencies ++= Seq(
    //"cc.factorie" % "factorie" % "1.0",
    //"org.scalamacros" %% "quasiquotes" % "2.0.0",
    //"org.scalanlp" %% "breeze" % "0.8.1",
    //"org.scalanlp" %% "breeze-natives" % "0.8.1",
    //"org.sameersingh.htmlgen" % "htmlgen" % "0.2-SNAPSHOT",
    //"edu.arizona.sista" % "processors" % "2.0",
    //"org.scala-lang" %% "scala-pickling" % "0.8.0"
  )

  val generalSettings =
    Seq(
      /*
      initialCommands := """
        import ml.wolfe.Wolfe._
        import ml.wolfe.macros.OptimizedOperators._
                         """
      */
    )

  def vmargs = Command.args("vmargs", "<name>") {
    (state, args) =>
      val javaRunOptions = args.mkString(" ")
      println("Applying JVM arguments: " + javaRunOptions)
      Project.extract(state).append(javaOptions := Seq(javaRunOptions), state)
  }

  val globalSettings =
    Seq(
      commands ++= Seq(vmargs),
      scalacOptions ++= Seq("-feature"),
      resolvers ++= Seq(
        "IESL Release" at "https://dev-iesl.cs.umass.edu/nexus/content/groups/public",
        Resolver.sonatypeRepo("snapshots"),
        Resolver.sonatypeRepo("releases"),
        "IESL third party" at "https://dev-iesl.cs.umass.edu/nexus/content/repositories/thirdparty/",
        "UCL snapshots" at "http://homeniscient.cs.ucl.ac.uk:8081/nexus/content/repositories/snapshots/",
        "IESL snapshots" at "https://dev-iesl.cs.umass.edu/nexus/content/repositories/snapshots",
        "IESL releases" at "https://dev-iesl.cs.umass.edu/nexus/content/repositories/releases",
        "Wolfe Release" at "http://homeniscient.cs.ucl.ac.uk:8081/nexus/content/repositories/releases",
        "Wolfe Snapshots" at "http://homeniscient.cs.ucl.ac.uk:8081/nexus/content/repositories/snapshots"
        ),
      globalDependencies
    ) ++ generalSettings ++ instrumentSettings //++ coverallsSettings

  ScoverageKeys.excludedPackages in ScoverageCompile := ".*;.*.*"
}


object StatNLPBuild extends Build {
  import BuildSettings._

  lazy val root = Project(
    id = "statnlp",
    base = file("."),
    settings = Project.defaultSettings ++ generalSettings
  ) aggregate(tutorial, assignments)
  //) aggregate(wolfe, tutorial, assignments)

  //lazy val wolfe = RootProject(file("../wolfe"))

  lazy val tutorial = Project(
    id = "statnlp-tutorial",
    base = file("statnlp-tutorial"),
    settings = buildSettings ++ globalSettings
  ) //dependsOn (wolfe % "test->test;compile->compile;test")

  lazy val assignments = Project(
    id = "statnlp-assignments",
    base = file("statnlp-assignments"),
    settings = buildSettings ++ globalSettings
  ) //dependsOn (wolfe % "test->test;compile->compile;test")
}
