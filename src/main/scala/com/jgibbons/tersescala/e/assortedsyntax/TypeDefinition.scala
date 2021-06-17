package com.jgibbons.tersescala.e.assortedsyntax

trait Fish
case class Cod(size:Double) extends Fish :
  override def toString() = "Cod"

@main def typeDefinition =
  type S = String
  type I = Int
  def display(s:S, i:I, f:Fish) = println(s"$i ${f}s $s")
  display("jump", 10, Cod(2.0) )


