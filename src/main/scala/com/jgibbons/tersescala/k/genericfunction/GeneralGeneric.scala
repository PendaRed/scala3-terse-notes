package com.jgibbons.tersescala.k.genericfunction

case class Formatter[T](thing:T) :
  def formatMe : String =
    thing.toString.replace("\n", "\n\t\t")

@main def generalGeneric =
  val g1 = Formatter(1)
  val g2 = Formatter(
    """I am
      |a string
      |oh yes
      |""".stripMargin)

  println(g1.formatMe)
  println(g2.formatMe)