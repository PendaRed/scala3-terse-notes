package com.jgibbons.tersescala.d.controlstructures

@main def forYield =
  val query1Results = List("Caladan Brood","Anomanda Rake")
  val query2Results = List("Rasberry Pi Model 3","Surface Pro")

  val r =
    for
      userDetails <- query1Results
      equip <- query2Results
    yield
      Tuple2(userDetails,equip)

  println(r.mkString("\n"))

  // You can use guards and multiline yields
  println(
    for
      userDetails <- query1Results
      equip <- query2Results
      if !equip.startsWith("Ras")
    yield
      val firstName = userDetails.split(" ").head
      s"$firstName likes $equip"
  )
end forYield
