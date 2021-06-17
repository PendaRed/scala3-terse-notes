package com.jgibbons.tersescala.c.strings

@main def stringInterpolation =
  def show(nm:String) = println(s"My name is $nm")

  show("Jonathan")
  show("Bill")

