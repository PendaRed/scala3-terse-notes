package com.jgibbons.tersescala.f.traitsclassesobjects

// Primary constructor
class Person(name:String, age:Int) :
  private var weight:Double = 80

  // Auxilary constructor
  def this(name:String, age:Int, weight:Double) =
    this(name, age)
    this.weight = weight
