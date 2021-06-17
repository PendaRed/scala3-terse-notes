package com.jgibbons.tersescala.i.collections

@main def simpleUsefulFunctions =
  val l = (1 to 3).toList // make a range and convert to a list

  println(l.map((item: Int) => "+" * item).mkString(", "))
  println(l.map(item => "+" * item).mkString(", "))
  // _ is positional, ie the 1st _ means the 1st parameter
  println(l.map("+" * _).mkString(", "))

  println(l.filter(_==2))
