package com.jgibbons.tersescala.d.controlstructures

@main def forDo =
  val lst = List(1,2,3)
  for (i<-lst) do {println(s"First $i")}
  for i<-lst do println(s"Second $i")

  // A guard can be used as the last part
  for
    i<-lst
    if i>2
  do
    println(s"Third $i")

  // And you can use multiple generators and guards
  for
    i<-lst
    j<-(1 to 5) // This is a range used as a generator
    if i==2
    if j>4
  do
    println(s"Fourth i=$i j=$j")
