package com.jgibbons.tersescala.e.assortedsyntax

@main def intersectionTypes =
  trait Printable:
    def printMe:String
  trait Reportable:
    def reportMe:String

  def printReverse(s: Printable & Reportable) =
    s.reportMe
    s.printMe
