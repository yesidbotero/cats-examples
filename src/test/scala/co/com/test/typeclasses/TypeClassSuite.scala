package co.com.test.typeclasses

import org.scalatest.FunSuite
import typeclasses.Monoid
import typeclasses.MonoidLaws

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

  implicit val sumIntMonoid: Monoid[Int] = new Monoid[Int] {
    override def combine(a: Int, b: Int): Int = a + b

    override def empty: Int = 0
  }

  test("An instance of Monoid should comply the laws for a Monoid " +
    "and combining two numbers using its binary operation") {

    /* Now, we will implement an instance of Monoid
       This is a Monoid that is composed for the binary operation sum and the indetity element 0
     */

    /* the method isMonoid, require un implicit monoid.
    *  In this case the implicit monoid will be resolved by the compiler.
    *  the implicit monoid that will be resolved is in scope
    * */
    assert(MonoidLaws.isMonoid(2, 5))

    /*  In this case the compiler does not have to resolve any monoids
    *   because it is being supplied explicitly
    * */
    assert(MonoidLaws.isMonoid(2, 5)(sumIntMonoid))

    assert(sumIntMonoid.combine(1, 3) == 4)
  }
}
