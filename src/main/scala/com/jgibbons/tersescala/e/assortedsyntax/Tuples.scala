package com.jgibbons.tersescala.e.assortedsyntax

import scala.deriving.Mirror

@main def tuples() : Unit =
  case class Dto(id:Int, json:String)
  val a = Tuple3(1, "One", Dto(101, """{"key":3}"""))
  val b = (1, "One", Dto(101, """{"key":3}"""))
  val (c,d,e) = b
  println(s"($b, $c, $d) is from $b which is the same as $a")

  // Notes (x) is zero indexed, whereas _1
  println(s"Element of a tuple is [${a(1)}, or ${a._2}]")

  // Extract a case class into a tuple
  val aCaseClass = Dto(1,"""{"key":3}""")
  val asATuple: (Int, String) = Tuple.fromProductTyped(aCaseClass)
  // and then the reverse
  val caseAgain: Dto = summon[Mirror.Of[Dto]].fromProduct(asATuple)

  println(s"[$aCaseClass] [$asATuple] [$caseAgain]")

  // Wierdly the :* and *: operations will not compile, Jan 15th 2022
  val tup1 : Tuple3[Int,String, Int]= (1,"Two", 3)
  val tup2 = ("Apple", "Orange")

  //val prepend = tup1 :* tup2
  //val append = tup1 *: tup2
  println(s"Concatination $tup1 ++ $tup2 results in ${tup1 ++ tup2}")
  //  println(s"Prepending $tup1 :* $tup2 results in ${tup1 :* tup2}")
  //println(s"Appending $tup1 *: $tup2 results in $append")