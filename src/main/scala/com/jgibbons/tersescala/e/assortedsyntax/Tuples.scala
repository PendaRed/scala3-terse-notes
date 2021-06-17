package com.jgibbons.tersescala.e.assortedsyntax

@main def tuples =
  case class Dto(id:Int, json:String)
  val a = Tuple3(1, "One", Dto(101, """{"key":3}"""))
  val b = (1, "One", Dto(101, """{"key":3}"""))
  val (c,d,e) = b
  println(s"($b, $c, $d) is from $b which is the same as $a")
