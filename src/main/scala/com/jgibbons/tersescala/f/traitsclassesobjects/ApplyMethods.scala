package com.jgibbons.tersescala.f.traitsclassesobjects

case class Foo(nm:String)
object Foo:
  def apply(i:Int,j:Int):Foo = new Foo(s"Integers $i $j")

@main def applyMethods =
  println(s"Default foo is ${Foo(1, 2)}")


