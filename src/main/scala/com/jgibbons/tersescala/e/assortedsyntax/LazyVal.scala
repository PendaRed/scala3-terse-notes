package com.jgibbons.tersescala.e.assortedsyntax

@main def lazyVal =
  lazy val thingy = {
    println("Thing")
    "thing"
  }
  val foo = {
    println("Foo")
    "foo"
  }

  if (thingy.nonEmpty) println("THINKY")
  if (foo.nonEmpty) println("FOO")
