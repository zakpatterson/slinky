package slinky.readwrite

import scala.language.{higherKinds, implicitConversions}
import scala.scalajs.js

@js.native
trait ObjectOrWritten[T] extends js.Object

object ObjectOrWritten {
  implicit def toUndefOrObject[T, O <: js.Object](value: js.Object): js.UndefOr[ObjectOrWritten[T]] = js.UndefOr.any2undefOrA(value.asInstanceOf[ObjectOrWritten[T]])
  implicit def fromObject[T, O <: js.Object](obj: O): ObjectOrWritten[T] = obj.asInstanceOf[ObjectOrWritten[T]]
  implicit def toUndefOrWritten[T](value: T)(implicit writer: Writer[T]): js.UndefOr[ObjectOrWritten[T]] = js.UndefOr.any2undefOrA(writer.write(value).asInstanceOf[ObjectOrWritten[T]])
  implicit def fromWritten[T](v: T)(implicit writer: Writer[T]): ObjectOrWritten[T] = writer.write(v).asInstanceOf[ObjectOrWritten[T]]
}
