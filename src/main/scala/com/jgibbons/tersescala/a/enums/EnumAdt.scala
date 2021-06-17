package com.jgibbons.tersescala.a.enums

enum Gender:
  case Male, Female

// Don't forget the val to make it a field rather than just a ctor arg.
enum Sapient(val gender:Gender):
  case Man extends Sapient(Gender.Male)
  case Woman extends Sapient(Gender.Female)

enum Group(val desc:String, val folk:List[Sapient]):
  case Staff(f:List[Sapient]) extends Group("Staff", f)
  case Clients(f:List[Sapient]) extends Group("Clients", f)

  def countGenders():Map[Gender, Int] =
    folk.groupBy(p=>p.gender).map{case (sex, lst) => sex-> lst.size}

@main def enumAdt =
  import Group.*
  import Sapient.*
  val people = Staff(List(Woman, Man, Woman, Woman))
  // outputs 1: Male, 3: Female
  println(people.countGenders().map{case (k,v)=>s"$v: $k"}.mkString(", "))

