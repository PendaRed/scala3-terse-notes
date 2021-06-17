package com.jgibbons.tersescala.i.collections

@main def maps =
  val kings = Map(
    "Penda"->"Wessex",
    "Oswald" -> "Northumbria",
    "Ecgberht" -> "Wessex")

  // convert an entry to just the value
  val kingdoms0 = kings.map(entry=>entry._2).toList // List[String]
  // Use sugar to remove boilerplace, placeholder _
  val kingdoms1 = kings.map(_._2).toList // List[String]
  // Use a partial function to extract the key and value from the entry
  val kingdoms2 = kings.map{case (k,v)=>v}.toList // List[String]
  // replace k with _ as we dont care about it
  val kingdoms3 = kings.map{case (_,v)=>v}.toList // List[String]
  // actually just grab the values
  val kingdoms4 = kings.values.toList

  // map is immutable, so add a value and get a new map.
  val kings2 = kings + ("Alfred"->"Wessex")
  println(kings2.mkString(", "))

  // You can extract the keys and values in for
  for (who, where) <- kings do println(s"$who ruled $where")
end maps