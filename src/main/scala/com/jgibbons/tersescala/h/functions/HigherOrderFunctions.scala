package com.jgibbons.tersescala.h.functions

@main def higherOrderFunctions =
  def callMe(name:String, fn: (String, Int)=>Int) =
    fn(name, name.length)

  def oneParam(name:String, fn: (String)=>Int) = fn(name)

  def addLen(s:String, len:Int) : Int =
    len+s.length

  // Passing a function as a parameter
  println(callMe("Anomander", addLen))
  // passing a lambda
  println(callMe("Anomander", (s:String, len:Int)=> len+s.length))

  def len(s:String) = s.length

  // Sugar for single param
  println(oneParam("Anomander", s => len(s)))
  // Sugar for single param lambda, _ as a positional reference
  println(oneParam("Anomander", len(_)))
  // Sugar again for a single param, no positional reference needed!
  println(oneParam("Anomander", len))

  // making a value from an anonymous function
  val foo = (s:String) => s.length
