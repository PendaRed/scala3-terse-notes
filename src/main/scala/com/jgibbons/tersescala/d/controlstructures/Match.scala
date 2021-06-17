package com.jgibbons.tersescala.d.controlstructures

enum Sex:
  case Male, Female

case class Person(forename:String, lastName:String, gender:Sex, age:Int)

@main def matcher =
  // very silly collection on numbers and people
  val folk = Vector[Any](
    Person("Anomander", "Rake", Sex.Male, 4000),
    Person("Caladan", "Brook", Sex.Male, 4000),
    1,2,3)

  val idx = (Math.random()*folk.length).toInt
  folk(idx) match {
    // calls unaply method, underscore means don't want it
    // This extracts the fields from the case class, and uses a guard as well
    case Person(fname, _, _, _) if fname=="Anomander" =>
      println("Its Anomander the Lord")
    case p @ Person(_, "Brook", _, _) => // Matching the surname value and aliasing to p
      println(s"Its $p")
    case 1|2|3 => println("A number") // match multiple value
    case _ =>
      println("Some unimportant person")
  }

  // You can just compare by type, and you can use allias as well.
  def getAStr(x:Any):String = x match
    case i:Int => "Integer"
    case d:Double => "Double"
    case List(first, _*) => s"List with head $first"
    case anything @ _ => s"unknown ${anything.getClass.getSimpleName}" // Alliasing the wild card

  println(
    s"""So:
       |${getAStr(1)}
       |${getAStr(1.0)}
       |${getAStr(List("head","mid","tail"))}
       |${getAStr(folk(0))}
       |""".stripMargin)
end matcher