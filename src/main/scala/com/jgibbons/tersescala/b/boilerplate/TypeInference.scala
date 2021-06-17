package com.jgibbons.tersescala.b.boilerplate

@main def typeInference =
  val iAmInt = 3
  val iAmString = "Cornovii"

  def aTribe(i:Int) = iAmString // infers return type of String
  val s = aTribe(iAmInt)  // infers s is a string
  println(s"It works ${s.getClass.getName}")
end typeInference
