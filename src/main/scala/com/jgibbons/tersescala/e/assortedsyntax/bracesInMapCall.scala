package com.jgibbons.tersescala.e.assortedsyntax

@main def bracesInMapCall =
  val s1 = (1 to 3).map(_ + 1).mkString(", ")
  val s2 = (1 to 3).map{
    case 2 => 4
    case i => i
  }.mkString(", ")

  val s3 = Map("s"->2,"t"->3).map((k,v) => k->(v+1)).mkString(", ")

  println(
    s"""$s1
       |$s2
       |$s3
       |""".stripMargin)