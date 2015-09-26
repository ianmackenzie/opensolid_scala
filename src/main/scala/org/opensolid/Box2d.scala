package org.opensolid

import scala.scalajs.js
import js.annotation.JSExport
import js.annotation.JSExportAll

@JSExport("Box2d")
@JSExportAll
case class Box2d(x: Interval, y: Interval) extends Bounded2d {
  def bounds: Box2d = this
}

@JSExport("Box2d_StaticMembers")
object Box2d {
  @JSExport("EMPTY")
  val Empty = Box2d(Interval.Empty, Interval.Empty)

  @JSExport("WHOLE")
  val Whole = Box2d(Interval.Whole, Interval.Whole)

  @JSExport("UNIT")
  val Unit = Box2d(Interval.Unit, Interval.Unit)
}
