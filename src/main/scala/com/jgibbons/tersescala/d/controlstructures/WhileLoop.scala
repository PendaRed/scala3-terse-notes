package com.jgibbons.tersescala.d.controlstructures

@main def whileLoop =
  def f(i:Int) :Int =
    println(s"called f with $i")
    if (Math.random()<0.2) -1 else i

  var x = f(1)
  while x >= 0 do x = f(x)

  x = 2
  while (x >= 0) {x = f(x)} // Scala 2 compatable

  x=f(3)
  while // multiline
    x >= 0
  do
    x = f(x)

