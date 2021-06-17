package com.jgibbons.tersescala.d.controlstructures

@main def tryCatchFinally = 
  try
    val i = 0
    val j = 0
    i/j
  catch
    case ex: ArithmeticException => println(s"I expected that: ${ex.getMessage}")
    case ex: Throwable => println(s"Oh dear ${ex.getClass.getName}")
  finally
    println("I would normally close something")
