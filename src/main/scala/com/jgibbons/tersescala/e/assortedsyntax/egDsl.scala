package com.jgibbons.tersescala.e.assortedsyntax

case class Dragon(projectile:String="", target:String="") :
  infix def shoots(projectile:String): Dragon = this.copy(projectile=projectile)
  infix def at(target:String): Dragon = this.copy(target=target)

trait DragonsTest :
  protected val Smaug=Dragon()

class MyFirstProg extends DragonsTest:
  Smaug shoots "Fire" at "Bilbo"
  // Which is the same as
  Smaug.shoots("Fire").at("Bilbo")
