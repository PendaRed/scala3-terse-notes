package com.jgibbons.tersescala.e.assortedsyntax

@main def opaqueType =
  object SafePerson :
    type SafeMobile = String
    opaque type SafeName = String
    def genName(n:String):SafeName = n
    def showSafe(n:SafeName, m:SafeMobile):String = s"$n m:$m"

  val name : SafePerson.SafeName = SafePerson.genName("Anomander")
  val mobile : String = "000100010001"

  // mobile was allowed as a String paraameter, it leaked out that String was fine.
  // but name had to go through the genName factory function
  // which created the right type.  Only SafePerson is aware that SafeName is
  // implemented as a String.
  SafePerson.showSafe(name, mobile)
