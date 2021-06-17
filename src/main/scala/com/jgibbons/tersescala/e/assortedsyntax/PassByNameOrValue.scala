package com.jgibbons.tersescala.e.assortedsyntax

@main def PassByNameOrValue =
  var n = 0
  def counterFn() =
    n= n+1
    n
  end counterFn

  def byValue(counter:Int) =
    println(s"byValue1  = $counter")
    println(s"byValue2  = $counter")

  def byName(counter: =>Int) =
    println(s"byName1  = $counter")
    println(s"byName2  = $counter")

  byValue(counterFn())
  n=0
  byName(counterFn())

