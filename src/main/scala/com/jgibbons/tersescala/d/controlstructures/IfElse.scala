package com.jgibbons.tersescala.d.controlstructures

@main def ifElse =
  val x = Math.random()*10.toInt
  if x<5 then   // Note (x<5) is not needed
    println("Unlucky")
  else if x<7 then
    println("Average")
  else
    println("lucky")
  end if // This is optional

  // The if is really an expression, so returns a value, which is inferred to be string
  val result = if x<5 then "Unlucky" else "Lucky"
  println(s"You are very $result")

  // You can still use if () {} else {} format if you prefer.
  val oldWay = if (x<5) "Unlucky" else "Lucky"
  println(s"And now you are very $oldWay")
end ifElse
