package instances
import typeclasses.Monoid

object MonoidInstances {
   implicit val orBoolean = new Monoid[Boolean] {
     override def combine(a: Boolean, b: Boolean): Boolean = a || b

     override def empty: Boolean = false
   }

  implicit val andBoolean = new Monoid[Boolean] {
    override def combine(a: Boolean, b: Boolean): Boolean = a && b

    override def empty: Boolean = true
  }
}
