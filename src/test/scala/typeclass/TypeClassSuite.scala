package scala.typeclass

import org.scalatest.FunSuite
import typeclasses.{Monoid, MonoidLaws}

/*  This Suite was built using an own implementation of Monoid */

class TypeClassSuite extends FunSuite {

  /*
    A type class is an interface or API that represents some functionality we want to implement.

    A monoid has two basic properties; the first one is a closed binary operation and the second one
    a identity element. These properties look like this

    trait Semigroup[A]{
      def combine(a: A, b: A): A
    }

    trait Monoid[A] extends Semigroup[A]{
      def empty: A
    }

    we are representing the behaviors or properties of a Monoid
  */

  test("An instance of Monoid should comply the laws for a Monoid " +
    "and combining two numbers using its binary operation") {

    /* Now, we will implement an instance of Monoid
       This is a Monoid that is composed for the binary operation sum and the indetity element 0
     */

    val sumIntMonoid = new Monoid[Int] {
      override def combine(a: Int, b: Int): Int = a + b

      override def empty: Int = 0
    }

    assert(MonoidLaws.isMonoid(2, 5)(sumIntMonoid))

    assert(sumIntMonoid.combine(1, 3) == 4)
  }
}
