package com.jgibbons.tersescala.d.controlstructures

@main def forComprehensionSugar =
  val v1 = for {
    i1 <- (1 to 3)
    _ = println(s"i1=$i1")
    j1 <- (4 to 6)
    t = j1*i1
    if (j1!=5)
  } yield (i1, j1, t)

  val v2= (1 to 3)
    .flatMap({ case i1 =>
      println(s"i1=$i1")
      (4 to 6)
        .withFilter({case j1=> j1!= 5})
        .map({ case j1 =>
          val t = j1 * i1
          (i1, j1, t)
        })
    })
  println(s"v1 = $v1")
  println(s"v2 = $v2")

