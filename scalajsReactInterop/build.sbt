enablePlugins(ScalaJSBundlerPlugin)

name := "slinky-scalajsreact-interop"

libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "1.2.0"

libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.8" % Test

libraryDependencies += "org.scala-js" %% "scalajs-env-jsdom-nodejs" % "1.0.0-RC2"

npmDependencies in Test += "react" -> "16.8.1"
npmDependencies in Test += "react-dom" -> "16.8.1"
jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv

scalacOptions += "-P:scalajs:sjsDefinedByDefault"
