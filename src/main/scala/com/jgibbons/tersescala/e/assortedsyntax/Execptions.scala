package com.jgibbons.tersescala.e.assortedsyntax

import java.security.InvalidParameterException
import scala.util.*

def iCanFail() :Int =
  if Math.random()<0.5 then throw new InvalidParameterException("Bang")
  1

// Returns a Success(1) or a Failyre(InvalidParameterException("Bang"))
def iCanFailBetter() : Try[Int]=
  Try {
    if Math.random() < 0.5 then throw new InvalidParameterException("Bang")
    1
  }

@main def execptions =
  // You can still do this, but really you should not.
  try
    iCanFail()
  catch
    case ex:InvalidParameterException => // expected
    case ex @ _ => println(s"NOT EXPECTED - ${ex.getClass.getName}:${ex.getMessage}")
  finally
    println("Done")

  iCanFailBetter()
    .map(println(_))  // Only Success(result) will execute this
    .recover{case ex:Throwable=> Try{println(s"NOT EXPECTED - ${ex.getClass.getName}:${ex.getMessage}")}}
  // Or
  iCanFailBetter() match
    case Success(i) => println(i)
    case Failure(ex) => println(s"NOT EXPECTED - ${ex.getClass.getName}:${ex.getMessage}")

  val result : Try[Int]= for {
    res1 <- iCanFailBetter()
    res2 <- iCanFailBetter() // only fires if res1 works
  } yield res2
  result
    .map(println(_))  // Only Success(result) will execute this
    .recover{case ex:Throwable=> Try{println(s"NOT EXPECTED - ${ex.getClass.getName}:${ex.getMessage}")}}


