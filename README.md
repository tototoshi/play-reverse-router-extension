# play-reverse-router-extension

[![Scala CI](https://github.com/tototoshi/play-reverse-router-extension/actions/workflows/scala.yml/badge.svg)](https://github.com/tototoshi/play-reverse-router-extension/actions/workflows/scala.yml)

## Install

```scala
lazy val example = project.in(file("example"))
  .enablePlugins(PlayScala)
  .settings(
    scalaVersion := "2.12.2",
    TwirlKeys.templateImports += "com.github.tototoshi.play.reverserouter.Implicits._",
    libraryDependencies ++= Seq(
      // for Play 2.9
      "com.github.tototoshi" %% "reverse-router-extension" % "0.5.0"
      // for Play 2.8
      "com.github.tototoshi" %% "reverse-router-extension" % "0.4.0"
      // for Play 2.7
      "com.github.tototoshi" %% "reverse-router-extension" % "0.3.0"
      // for Play 2.6
      "com.github.tototoshi" %% "reverse-router-extension" % "0.2.0"
      // for Play 2.5
      // "com.github.tototoshi" %% "reverse-router-extension" % "0.1.0"
    )
  )
```

## Usage

```html
<a href="@routes.HomeController.index().withQueryString("a" -> "aaa", "b" -> "bbb", "b" -> "ccc")">link</a>
```


## License

[Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)
