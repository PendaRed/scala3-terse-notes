package com.jgibbons.tersescala.e.assortedsyntax

@main def varargs =
  def iTakeStrings(strs:String*) =
    strs.foreach(e=>println(s"I am a param printer $e"))

  iTakeStrings("1")
  iTakeStrings("a", "b")