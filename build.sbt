val _version = "0.2.0"

val scalaVersion_2_12 = "2.12.2"
val scalaVersion_2_11 = "2.11.8"

val playVersion = play.core.PlayVersion.current

lazy val baseSettings = Seq(
  organization := "com.github.tototoshi",
  scalaVersion := scalaVersion_2_12,
  crossScalaVersions := Seq(scalaVersion_2_11, scalaVersion_2_12),
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.0.1" % "test"
  )
)

lazy val `extension` = project.in(file("extension"))
  .settings(baseSettings)
  .settings(
    name := "reverse-router-extension",
    version := "0.2.0",
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play" % playVersion
    )
  )
  .settings(publishSettings)

lazy val example = project.in(file("example"))
  .enablePlugins(PlayScala)
  .settings(baseSettings)
  .settings(
    TwirlKeys.templateImports += "com.github.tototoshi.play.reverserouter.Implicits._"
  )
  .settings(nonPublishSettings)
  .dependsOn(`extension`)

lazy val root = project.in(file("."))
  .settings(baseSettings)
  .settings(nonPublishSettings)
  .aggregate(`extension`, example)

def _publishTo(v: String) = {
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

lazy val nonPublishSettings = Seq(
  publishArtifact := false,
  publish := {},
  publishLocal := {}
)

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishTo <<= version { (v: String) => _publishTo(v) },
  publishArtifact in Test := false,
  pomExtra :=
    <url>http://github.com/tototoshi/play-reverse-router-extension</url>
      <licenses>
        <license>
          <name>Apache License, Version 2.0</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:tototoshi/play-reverse-router-extension</url>
        <connection>scm:git:git@github.com:tototoshi/play-reverse-router-extension.git</connection>
      </scm>
      <developers>
        <developer>
          <id>tototoshi</id>
          <name>Toshiyuki Takahashi</name>
          <url>http://tototoshi.github.io</url>
        </developer>
      </developers>
)
