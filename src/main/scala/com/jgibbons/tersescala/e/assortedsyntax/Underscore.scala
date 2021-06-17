package com.jgibbons.tersescala.e.assortedsyntax

@main def underscore =
  val l = List(1,2,3)
  // Placeholder syntax.  In anonymous function the first _ will
  // match the first param, the second the second param and so on.
  val lPlus1 = l.map(_+1)
  // Placeholder again, where _ + _ is first parm + 2nd param
  val tot = l.reduce(_ + _)

  // In a match it means anything
  "b" match
    case _ => println("Anything!")

  // When seperating a number
  val aMillion = 1_000_000

  // When using an extractor (unapply) and don't care about a field
  case class Fruit(n:String, sz:Int)
  Fruit("Apple", 10) match
    case Fruit(name, _) => println(name)



