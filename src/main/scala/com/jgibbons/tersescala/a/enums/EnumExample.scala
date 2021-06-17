package com.jgibbons.tersescala.a.enums

enum Tribes:
  case Belgae, Brigantes, Cantii, Carvetii

@main def showTribes: Unit =
  println(s"Tribes enums are : ${Tribes.values.mkString("\n\t")}")
