package interfaces

import typeclasses.Monoid

object MonoidSyntax {
  implicit class monoidOps[A](value1: A) {
    def combine(value2: A)(implicit monoid: Monoid[A]): A = {
      monoid.combine(value1, value2)
    }
  }
}
