package com.jgibbons.tersescala.f.traitsclassesobjects

class Doggy(private val name:String) : // private member
  val fullName = name+" surname" // public
  private val nickname = name.substring(0,3) // private member
  private[traitsclassesobjects] val iAmPackageScope = 2


@main def scopes =
  val p = Doggy("Jonathan")
  println(p.fullName)
//  println(p.name) // error
//  println(p.nickname) // error
  println(p.iAmPackageScope)

