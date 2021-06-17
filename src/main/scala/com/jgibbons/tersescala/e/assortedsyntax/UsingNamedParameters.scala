package com.jgibbons.tersescala.e.assortedsyntax

@main def usingNamedParameters =
  def fn1(fname:String, sname:String, age:Int = 6) =
    s"$fname $sname $age"

  // Parameter order no longer matters, as naming the parameters
  // no value given for the default parameters
  val s = fn1(sname="Rake", fname="Anomander")
  println(s)
