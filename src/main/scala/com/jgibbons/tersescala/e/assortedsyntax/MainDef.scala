package com.jgibbons.tersescala.e.assortedsyntax

@main def mainDef =
  println("Hello world")

@main def mainWithArg(nm:String) =
  println(s"Hello $nm")

object MyMain extends App :
  println("Hello World")

object ReallyMain :
  def main(args:Array[String]) =
    println(s"Hello ${args(0)}")
