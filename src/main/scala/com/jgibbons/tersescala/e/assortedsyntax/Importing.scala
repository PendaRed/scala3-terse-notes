package com.jgibbons.tersescala.e.assortedsyntax

package foo {
  import bar.{silly1, silly3} // multiple imports
  val TopLevelInt1 = 1
  val TopLevelInt2 = 2
  val TopLevelInt4 = 2
}

package bar {
  import foo.*
  def silly1() = println(TopLevelInt1)
  def silly2() = println(TopLevelInt2)
  def silly3() =
    import watever.TopLevelInt3 // imports can be anywhere
    println(TopLevelInt3)
  object P2:
    def doStuff() = println("Stuff done")
}

package watever {
  val TopLevelInt3 = 3
  import foo.{TopLevelInt1 as _, TopLevelInt4 as _, *} // hide TopLevelInt1 and 4
  import bar.{silly1 as barSilly1} // rename it
  def silly1() = barSilly1()

  class G(n:String):
    import bar.P2.*  // can access P2.doStuff as doStuff now
    doStuff()
}
