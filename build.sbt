val scalaVersion_2_13 = "2.13.12"
val scalaVersion_3 = "3.3.1"

val playVersion = play.core.PlayVersion.current

lazy val baseSettings = Seq(
  organization := "com.github.tototoshi",
  scalaVersion := scalaVersion_2_13,
  crossScalaVersions := Seq(scalaVersion_2_13, scalaVersion_3),
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (version.value.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.17" % "test"
  )
)

lazy val `extension` = project.in(file("extension"))
  .settings(baseSettings)
  .settings(
    name := "reverse-router-extension",
    version := "0.6.0",
    libraryDependencies ++= Seq(
      "org.playframework" %% "play" % playVersion
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

lazy val nonPublishSettings = Seq(
  publishArtifact := false,
  publish := {},
  publishLocal := {}
)

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishArtifact in Test := false,
  pomExtra :=
    <url>https://github.com/tototoshi/play-reverse-router-extension</url>
      <licenses>
        <license>
          <name>Apache License, Version 2.0</name>
          <url>https://www.apache.org/licenses/LICENSE-2.0.html</url>
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
          <url>https://tototoshi.github.io</url>
        </developer>
      </developers>
)
