package com.jgibbons.tersescala.c.strings

@main def multiLine : Unit =
  println(
    s"""I will show some maths
       |1+1=${if (Math.random()>0.5) 1+1 else 3}
       |2+2=${2 + 2}
       |""".stripMargin)
