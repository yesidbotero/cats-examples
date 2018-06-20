package interfaces

import typeclasses.Printable

object Printer {
  def format[A](value: A)(implicit printer: Printable[A]): String = {
    printer.format(value)
  }

  def print[A](value: A)(implicit printer: Printable[A]): Unit = {
    println(format(value))
  }
}

object PrintableSyntax {

  implicit class PrintableOps[A](value: A) {
    def format(implicit printer: Printable[A]): String = {
      printer.format(value)
    }

    def print(implicit printer: Printable[A]): Unit = {
      println(printer.format(value))
    }
  }

}
