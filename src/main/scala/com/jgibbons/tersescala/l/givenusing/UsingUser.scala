package com.jgibbons.tersescala.l.givenusing

import com.jgibbons.tersescala.l.givenusing.UserSession

@main def UsingUser =
  import SessionUtil.*

  val u1 = User(1,"Anomander", Map("search"->true))
  val sess = UserSession(u1)

  // Explicitly use u1 as the contextual parameter
  confirmPermission("search")(using u1)
  // Now make u1 a contextual parameter, so no need to give it
  given User = u1
  logUser()

  if (isAllowed("saerch")) then
    println("foo")
  end if
  {
    // put into its own expression block to scope the given
    given UserSession = sess
    doSearch()
  }
  // Cannot redefine the given instance in the same scope
  given UserSession = UserSession(u1.copy(permissions = Map.empty))
  doSearch()