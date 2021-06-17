package com.jgibbons.tersescala.f.traitsclassesobjects

trait Flyer
trait Walker
trait Crawler
trait Swimmer

class Camel(n:String) extends Walker
class Snake(n:String) extends Crawler, Swimmer
class Penguin(n:String) extends Crawler, Swimmer, Walker
