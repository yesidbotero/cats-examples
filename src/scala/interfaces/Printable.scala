package interfaces

import typeclasses.Printable

object Printable {
  def format[A](value: A)(implicit printer: Printable[A]): String = {
    printer.format(value)
  }

  def print[A](value: A)(implicit printer: Printable[A]): Unit = {
    println(format(value))
  }
}
