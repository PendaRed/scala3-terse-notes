package com.jgibbons.tersescala.e.assortedsyntax

trait Plant :
  def shineOnMe():Unit

trait Living :
  self : Plant =>
  shineOnMe()

trait StillLiving :
  foobar : Plant => // can be any valid identifier
  shineOnMe()

