package com.jgibbons.tersescala.l.givenusing

import java.time.LocalDateTime

case class User(id:Int, username:String, permissions:Map[String,Boolean])
case class UserSession(user:User, startTimeMs:LocalDateTime = LocalDateTime.now)

object SessionUtil {
  def logUser()(using u:User) :Unit=
    println(u.username)

  def confirmPermission(perm:String)(using u:User) :Boolean=
    u.permissions.getOrElse(perm, false)

  // Notice here we do not access User in this function, so no local variable name
  def isAllowed(perm:String)(using User) : Boolean =
    if (confirmPermission(perm)) then
      logUser()
      true
    else
      false

  def doSearch()(using sess:UserSession) = {
    // explicit using param extracted from my contextual param
    if (isAllowed("search")(using sess.user))
      println("I am searching")
    else
      println("Disallowed")
  }
}
