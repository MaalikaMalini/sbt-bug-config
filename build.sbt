// *****************************************************************************
// Projects
// *****************************************************************************

lazy val Config =
  project
    .in(file("."))
    .enablePlugins(AutomateHeaderPlugin)
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        library.scalaCheck % Test,
        library.scalaTest  % Test,
        library.pureConfig,
        library.doobieCore,
        library.doobieHikari,
        library.doobiePostgres,
        library.postgresql,
        library.catsCore,
        library.http4sBlazeClient,
        library.http4sDsl,
        library.jsoup,
        library.doobieCore,
        library.doobieHikari,
        library.doobiePostgres
      )
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    object Version {
      val scalaCheck = "1.14.2"
      val scalaTest  = "3.0.8"
      val pureConfig = "0.12.1"
      val doobie = "0.7.1"
      val kittens = "2.0.0"
      val postgresql = "42.2.8"
      val cats = "2.0.0"
      val http4s = "0.20.15"
      val jsoup = "1.12.1"
    }
    val scalaCheck = "org.scalacheck" %% "scalacheck" % Version.scalaCheck
    val scalaTest  = "org.scalatest"  %% "scalatest"  % Version.scalaTest
    val pureConfig = "com.github.pureconfig" %% "pureconfig" % Version.pureConfig
    val doobieCore = "org.tpolecat" %% "doobie-core" % Version.doobie
    val doobieHikari = "org.tpolecat" %% "doobie-hikari" % Version.doobie
    val doobiePostgres = "org.tpolecat" %% "doobie-postgres" % Version.doobie
    val postgresql = "org.postgresql" % "postgresql" % Version.postgresql
    val catsCore = "org.typelevel" %% "cats-core" % Version.cats
    val http4sBlazeClient = "org.http4s" %% "http4s-blaze-client" % Version.http4s
    val http4sDsl = "org.http4s" %% "http4s-dsl" % Version.http4s
    val jsoup = "org.jsoup" % "jsoup" % Version.jsoup
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings =
  commonSettings ++
  scalafmtSettings

lazy val commonSettings =
  Seq(
    scalaVersion := "2.12.10",
    organization := "com.wegtam",
    organizationName := "Maalikamalini Chandrasekar",
    startYear := Some(2019),
    licenses += ("AGPL-3.0", url("https://www.gnu.org/licenses/agpl.html")),
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-language:_",
      "-target:jvm-1.8",
      "-encoding", "UTF-8",
      "-Ywarn-unused:imports",
    ),
    Compile / unmanagedSourceDirectories := Seq((Compile / scalaSource).value),
    Test / unmanagedSourceDirectories := Seq((Test / scalaSource).value),
    Compile / compile / wartremoverWarnings ++= Warts.unsafe,
)

lazy val scalafmtSettings =
  Seq(
    scalafmtOnCompile := true,
  )
