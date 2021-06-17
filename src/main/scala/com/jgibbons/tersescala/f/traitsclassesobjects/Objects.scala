package com.jgibbons.tersescala.f.traitsclassesobjects

import java.time.LocalDate

object CalUtil :
  private val endDate = LocalDate.of(2012, 12, 21)
  def endOfTheWorld(d: LocalDate): Boolean = d.isEqual(endDate)

@main def objects =
  import CalUtil.*
  println(
    s"""Is today the end of the world?
       |Answer: ${if (endOfTheWorld(LocalDate.now())) "Yes" else "No"}
       |""".stripMargin)
