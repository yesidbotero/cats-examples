import interfaces.Printer
import interfaces.PrintableSyntax.PrintableOps
import instances.PrintableInstances._
import model.Cat
import cats._
import cats.implicits._

object Main extends App {
  Printer.print(1)

  /* ---- */

  val cat = Cat("Mis", 3, "Black")
  Printer.print(cat)

  // Using interface syntax

  cat.print


  // Using Show typeclass

  val showInt: Show[Int] = Show.apply[Int]
  showInt.show(2)

  // using extension method for Int instance

  val showIntAsString = 2.show
  println(showIntAsString)





}