package com.jgibbons.tersescala.e.assortedsyntax

@main def readingTypes =
  // name colon type
  def str:String = "a string"

  // Function fn takes a parm of type String and returns type String
  def fn(param: String) : String = param.reverse

  // function looper takes
  //   a param p of type string
  //   a param fn of type : A function which takes a string and returns a string
  // and looper returns a string
  def looper(p:String, fn: String => String) : String = fn(p)

