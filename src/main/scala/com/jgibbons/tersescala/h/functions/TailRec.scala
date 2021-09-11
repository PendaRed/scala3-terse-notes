package com.jgibbons.tersescala.h.functions

import scala.annotation.tailrec

@main def TailRec =
  // the last expression is not a recursive call, it is n* recursive call
  def factorialNotTailRec(n: Int): Int = if (n == 0) 1 else n * factorialNotTailRec(n-1)

  @tailrec
  def rev(s:String, acc:List[Char] = List.empty[Char]) :String =
    if (s.length<1) acc.mkString("")
    else rev(s.substring(1), acc.prepended(s.charAt(0)))

  println(s"3!=${factorialNotTailRec(3)}")
  val s = "I am forwards"
  println(s"Silly reverse example [$s] reverses to [${rev(s)}]")