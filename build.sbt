lazy val `extension` = project.in(file("extension"))
  .settings(
    organization := "com.github.tototoshi",
    name := "reverse-router-extension",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.11.8",
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play" % "2.5.4"
    )
  )
  .settings(publishSettings)

lazy val example = project.in(file("example"))
  .enablePlugins(PlayScala)
  .settings(
    scalaVersion := "2.11.8",
    TwirlKeys.templateImports += "com.github.tototoshi.play.reverserouter.Implicits._"
  )
  .settings(nonPublishSettings)
  .dependsOn(`extension`)

lazy val root = project.in(file("."))
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
