package typeclasses

trait Semigroup[A]{
  def combine(a: A, b: A): A
}

trait Monoid[A] extends Semigroup[A]{
  def empty: A
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid
}

object MonoidLaws {
  private def associatveLaw[A](a: A, b: A)(implicit monoid: Monoid[A]): Boolean = {
    monoid.combine(a, b) == monoid.combine(b, a)
  }

  private def identityLaw[A](a: A)(implicit monoid: Monoid[A]): Boolean = {
    monoid.combine(a, monoid.empty) == a && monoid.combine(monoid.empty, a) == a
  }

  def isMonoid[A](a: A, b: A)(implicit monoid: Monoid[A]): Boolean = {
    associatveLaw(a, b) && identityLaw(a) && identityLaw(b)
  }
}
