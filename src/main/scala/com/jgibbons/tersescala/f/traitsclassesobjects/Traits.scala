package com.jgibbons.tersescala.f.traitsclassesobjects

trait Animal :
  def movement:String

object Human extends Animal :
  val movement = "Walks" // you can override a parameterless def with a val

class Cat extends Animal :
  // override not needed as movement is not a concrete method
  def movement = if Math.random<0.5 then "Walks" else "Jumps"

case class BigCat(name:String) extends Cat :
  println("I execute in the constructor")
  override def movement = "prowls" // override needed as its a concrete method

@main def traits =
  def move(a:Animal):String = a.movement

  println(move(Human))  // Only one Human ever
  println(move(Cat()))  // new keyword is not needed
  println(move(BigCat("Tiger")))
