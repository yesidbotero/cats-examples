import interfaces.Printer
import interfaces.PrintableSyntax.PrintableOps
import instances.PrintableInstances._
import instances.MonoidInstances._
import typeclasses.MonoidLaws
import instances.ShowCustomInstances._
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


  // using a Custom Show Instances for Cat

 val showCat: Show[Cat] = Show.apply[Cat]
  // using show method directly, without interfaces
  println(showCat.show(cat))

  // Eq for Int

  val eqInt = Eq.apply[Int]

  println(s"Comparing 1 with 3 using Eq instance for Int:  ${eqInt.eqv(1, 3)}")
  println(s"Comparing 3 with 3 using Eq interface sysntax: ${ 3 === 3}")


  //Monoid Exercise

  println(s"orBoolean instance is monoid ?: ${MonoidLaws.isMonoid(true, false)(orBoolean)}")
  println(s"andBoolean instance is s monoid ?: ${MonoidLaws.isMonoid(true, false)(andBoolean)}")









}