package com.jgibbons.tersescala.e.assortedsyntax
import scala.util.*

@main def egOption =
  def anOptionFn(f:String, l:String, m:Option[String]=None) =
    s"$f ${m.getOrElse("")} $l"

  println(anOptionFn("J", "G"))
  println(anOptionFn("J", "G", Some("P")))
  val o = Option(null) // gives a None, useful when calling Java
  o.foreach(v=>println("Will never print since o is None"))
  o.fold(println("Shows if None"))(v=>println("Shows if some")) // Nice trick
  o match
    case Some(v)=>println("v="+v)
    case None => println("None")
