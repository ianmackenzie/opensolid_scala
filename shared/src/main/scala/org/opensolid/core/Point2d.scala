package org.opensolid.core

final case class Point2d(x: Double, y: Double)
  extends Bounded2d with Transformable2d[Point2d] with Scalable2d[Point2d] {

  override def bounds: Box2d = Box2d(Interval(x), Interval(y))

  override def transformedBy(transformation: Transformation2d): Point2d = {
    transformation(this)
  }

  override def scaledAbout(point: Point2d, scale: Double): Point2d = point + scale * (this - point)

  def +(vector: Vector2d): Point2d = Point2d(x + vector.x, y + vector.y)

  def -(that: Point2d): Vector2d = Vector2d(x - that.x, y - that.y)
}

object Point2d {
  val Origin: Point2d = Point2d(0.0, 0.0)
}
