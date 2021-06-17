package com.jgibbons.tersescala.i.collections

def getAllStringsIn(s:String) =
  s.tails.flatMap(_.inits).filterNot(_.isEmpty).toSet

@main def funkyStuff =
  val str = "abcd"
  // abc,cd,ab,b,abcd,c,bcd,d,bc,a
  println(getAllStringsIn(str).mkString(","))

  val l = List.empty[String] // create an empty list
  val lAgain = List("a", "b", "c")
  val l1 = "a" :: "b" :: "c" :: Nil
  // Mattern matching on strings
  l1 match
    case List(h , _*) => println(s"First element is $h")
  l1 match
    case List(h , "b", "c") => println(s"First element is $h")

  val l3 = l1 :+ "d" // add to end, List(a, b, c, d)
  val l4 = "_" :: l1  // add to start, List(_, a, b, c)
  val l5 = "_" +: l1  // add to start, List(_, a, b, c)
  println(""+l3+"\n"+l4+"\n"+l5)

  // You should google and work this out for yourself.
  val a1 = List("A", "A", "B", "C", "C")
  val luvFolds = a1.foldLeft(scala.collection.mutable.Map.empty[String, Int])(
    (acc,element)=>
      val count :Int = acc.getOrElse(element, 0) +1
      acc += (element->count)
  )
  val whoNeedsFold = a1.groupBy(e=>e).map( (k,v)=>(k->v.size))
  println(""+luvFolds+"\n"+whoNeedsFold) // prints HashMap(A -> 2, B -> 1, C -> 2) twice

  List((1,"a"), (2, "b")).toMap // convert a list of Tuple2s to a map

  // Using a collection as a generator in a for statement
  for i <- a1 do println(s"Well $i")