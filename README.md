# play-reverse-router-extension

## Install

```scala
lazy val example = project.in(file("example"))
  .enablePlugins(PlayScala)
  .settings(
    scalaVersion := "2.11.8",
    TwirlKeys.templateImports += "com.github.tototoshi.play.reverserouter.Implicits._",
    libraryDependencies ++= Seq(
      "com.github.tototoshi" %% "reverse-router-extension" % "0.1.0"
    )
  )
```

## Usage

```html
<a href="@routes.HomeController.index().withQueryString("a" -> "aaa", "b" -> "bbb", "b" -> "ccc")">link</a>
```
