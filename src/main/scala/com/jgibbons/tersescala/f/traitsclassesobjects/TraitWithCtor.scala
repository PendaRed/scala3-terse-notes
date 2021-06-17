package com.jgibbons.tersescala.f.traitsclassesobjects

trait Insect
object Butterfly extends Insect
trait Caterpiller(legs:Int) extends Insect :
  def mutate:Insect = Butterfly

