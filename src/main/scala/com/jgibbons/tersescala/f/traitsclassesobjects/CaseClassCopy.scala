package com.jgibbons.tersescala.f.traitsclassesobjects

case class Car(make:String, model:String)

// silly example, but shows matching on case classes
def isItOutYet(c:Car) = c match
  case Car(_, model) if model=="Model 3" => true
  case _ => false

@main def caseClassCopy =
  val c1 = Car("Tesla", "Model 3")
  val cars = List(c1, c1.copy(model="Model Y"))
  cars.foreach(c=>println(s"$c is it out?  ${isItOutYet(c)}"))
