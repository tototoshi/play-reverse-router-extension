resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/maven-releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.7")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.9.7")

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.1.2")

// https://github.com/sbt/sbt/issues/6400
addSbtPlugin("com.typesafe.sbt" % "sbt-twirl" % "1.5.1")
