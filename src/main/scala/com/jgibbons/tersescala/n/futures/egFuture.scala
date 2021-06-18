package com.jgibbons.tersescala.n.futures

import java.time.*

def doSomeStuff(pauseMs:Long = 500, thenFail:Boolean = false) : LocalDateTime=
  println(s"${Thread.currentThread().getName} Busy")
  Thread.sleep(pauseMs)
  println(s"${Thread.currentThread().getName} ..Done")
  if (thenFail) throw new Exception("Failed")
  LocalDateTime.now()

@main def egFuture =
  import scala.concurrent._
  import scala.concurrent.duration._
  import scala.util.{Success, Failure}
  import concurrent.ExecutionContext.Implicits.global

  // just run something synchronously, is on my thread
  println(s"Synchronous finished at ${doSomeStuff()}")

  // The inferred type is Future[LocalDateTime]
  val notReadyYet : Future[LocalDateTime]= Future{doSomeStuff()}
  Await.result(notReadyYet, Duration.Inf) // normally not done, but I want you see the effect
  notReadyYet.onComplete {
    case Success(tm) => println(s"Async1 finished at $tm")
    case Failure(ex) => println(s"Failued with ${ex.getClass.getName}")
  }

  // Or without the interim variable
  Future{doSomeStuff()} onComplete {
    case Success(tm) => println(s"Async2 finished at $tm")
    case Failure(ex) => println(s"Failued with ${ex.getClass.getName}")
  }
  // Or you don't care about failure
  Future{doSomeStuff()}.foreach(tm =>println(s"Synchronous finished at $tm"))
  Thread.sleep(600)

  val fallback:LocalDateTime = LocalDateTime.of(2021,6,5,11,10,50)
  // Or you do care, and recover with
  Future{doSomeStuff(thenFail = true)}.recover {
      case ex:Throwable => fallback
    }.foreach(tm=>println(s"Failure finished at $tm"))
  Thread.sleep(600)



