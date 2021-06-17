package com.jgibbons.tersescala.i.collections

@main def javaInterop =
  import java.util.List as JavaList

  def gimmeAJavaList() =
    import scala.jdk.javaapi.CollectionConverters
    CollectionConverters.asJava(List("a", "b"))

  import scala.jdk.CollectionConverters.*
  val javaList: java.util.List[String] = gimmeAJavaList()
  val scalaList = javaList.asScala
