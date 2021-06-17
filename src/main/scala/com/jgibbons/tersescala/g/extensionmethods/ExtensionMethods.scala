package com.jgibbons.tersescala.g.extensionmethods

@main def ExtensionMethods =
  case class Person(fname:String, sname:String)

  extension(p:Person)
    def greet:String = s"Elbow bump ${p.fname}"
    def hug:String = s"Covid alert ${p.fname.toUpperCase}"

  val ano = Person("Anomander", "Rake")
  println(ano.greet)
  println(ano.hug)
