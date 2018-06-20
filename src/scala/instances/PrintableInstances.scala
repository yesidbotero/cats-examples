package instances
import model.Cat
import typeclasses.Printable
import interfaces.Printer

object PrintableInstances {
  implicit val stringPrintable  = new Printable[String] {
    override def format(value: String): String = value
  }

  implicit val intPrintable = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }

  implicit val catPrintable = new Printable[Cat] {
    override def format(cat: Cat): String =
      s"${Printer.format(cat.name)} is a ${Printer.format(cat.age)} year-old ${Printer.format(cat.color)} cat"
  }

}
