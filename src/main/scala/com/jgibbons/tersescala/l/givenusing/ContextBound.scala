package com.jgibbons.tersescala.l.givenusing

case class UserDao[T]() :
  def store(j:T) = println("do store")

object UserDaoUtil :
  def doStore[T](n:T)(using dao:UserDao[T]) =
    dao.store(n)

// Longhand, using clause
case class Foo[T](i:T)(using UserDao[T]) :
  UserDaoUtil.doStore(i)

// shorthand syntactic sugar
// Note the T : UserDao, this is context bound.  ie a contextual paramete
// must be Given which is of type UserDao[T]
case class FooCithContextBound[T : UserDao](i:T) :
  UserDaoUtil.doStore(i)


