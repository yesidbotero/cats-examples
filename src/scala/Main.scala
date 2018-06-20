import interfaces.Printer
import interfaces.PrintableSyntax.PrintableOps
import instances.PrintableInstances._
import model.Cat

object Main extends App {
  Printer.print(1)

  /* ---- */

  val cat = Cat("Mis", 3, "Black")
  Printer.print(cat)

  // Using interface syntax

  cat.print

}