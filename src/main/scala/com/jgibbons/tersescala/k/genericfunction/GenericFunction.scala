package com.jgibbons.tersescala.k.genericfunction

def ordinaryFn(i:Int) = "Silly Eg"+i
def genericFn[T](i: T) = "Silly Eg"+i

@main def genericFunction =
  println(ordinaryFn(2))
  println(genericFn(3))
  println(genericFn("Horse"))
