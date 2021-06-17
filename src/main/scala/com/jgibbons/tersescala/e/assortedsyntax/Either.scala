package com.jgibbons.tersescala.e.assortedsyntax

import scala.util.*

@main def either =
  def someThingDone():Either[String, String] =
    if Math.random()<0.5 then Left("Failed") else Right("Worked")

  // loop 5 times
  val l = (1 to 5).map(v=>
    someThingDone().map(v => "Good" +v).orElse(Right("Recovered"))
  )

  l.foreach(v=>v match {
    case Right(s) => println(s)
    case Left(ex) => println("Impossible")
  })
