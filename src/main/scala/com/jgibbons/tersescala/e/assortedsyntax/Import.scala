package com.jgibbons.tersescala.e.assortedsyntax

object Person :
  val CrowdSize=10
  def sit() = println("Sit")
  def walk() = println("Walk")

@main def importEg =
  {
    import Person.*
    println(s"Crowd = $CrowdSize")
  }
  {
    import Person.{sit, walk}
    //println(s"Crowd = $CrowdSize") // error!
  }

