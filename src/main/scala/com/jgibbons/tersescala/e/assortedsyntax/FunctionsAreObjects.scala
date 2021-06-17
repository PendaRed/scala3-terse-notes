package com.jgibbons.tersescala.e.assortedsyntax
def foo2(s:String) = s.length

@main def functionsAreObjects =
  val fn = foo2
  val fn1 = (s:String)=>s.length
  val lst = List(fn, fn1)
  // I put the type in to show you, for each string in a list of strings
  // I call each function from my list of functions.
  val mad :List[List[Int]]= List("A","BB").map( v => lst.map(f=>f(v)))
  //  lets use _ as a placeholder for the function....(really I wouldnt in my code)
  val madAgain :List[List[Int]]= List("A","BB").map( v => lst.map(_(v)))
