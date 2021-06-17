package com.jgibbons.tersescala.e.assortedsyntax

@main def unionTypes =
  case class RefreshListAction(rowNun:Int)
  case class CallServerAction(actionName:String)
  type UiAction = RefreshListAction | CallServerAction

  def reduceer(action: UiAction) = action match
    case RefreshListAction(rowNum)=>// do stuff
    case CallServerAction(actionName)=>// do stuff

