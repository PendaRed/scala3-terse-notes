package com.jgibbons.tersescala.m.typeclass

import java.util.Random

// Library written for a hour planning app
package kitchenlibrary :
  case class Spoon(metal:String)
  case class Fork(metal:String)
  case class FryingPan(diameter:Int)
end kitchenlibrary

// Library made for a battle simulator
package garagelibrary :
  import java.util.Random

  trait Tool(damage:Int) :
    def damage()(using rnd:Random):Int = damage/2+rnd.nextInt(damage)

  case class Hammer() extends Tool(10)
  case class Wrench() extends Tool(15)
  case class ScrewDriver() extends Tool(5)
end garagelibrary

// Now I want to fight in the house
package mynewlibrary :
  import kitchenlibrary.*
  import garagelibrary.ScrewDriver

  trait Weaponized[A]:
    extension(a:A) def damageCaused()(using rnd:Random):Int

  given Weaponized[ScrewDriver] with
    extension(w:ScrewDriver) def damageCaused()(using rnd:Random):Int = w.damage()
  given Weaponized[Spoon] with
    extension(s:Spoon) def damageCaused()(using rnd:Random):Int = 2
  given Weaponized[Fork] with
    extension(s:Fork) def damageCaused()(using rnd:Random):Int = 4
  given Weaponized[FryingPan] with
    extension(s:FryingPan) def damageCaused()(using rnd:Random):Int = 7
end mynewlibrary

@main def egTypeClass = {
  import kitchenlibrary.*
  import garagelibrary.*
  import mynewlibrary.{given, *}

  def showDam[T:mynewlibrary.Weaponized](l:T)(using Random) =
    println(s"Damage taken from ${l.getClass.getSimpleName} is ${l.damageCaused()}")


  val rnd = new Random(20)
  given Random = rnd

  showDam(Spoon("Silver"))
  showDam(ScrewDriver())
}

