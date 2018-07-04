package co.com.test.cats

import cats._
import cats.implicits._
import org.scalatest.FunSuite

/* monoid is an abstraction of the concept of adding or combining  */

class Monoid extends FunSuite {

  val intSumMonoid = Monoid[Int]
  test("A monoid can be user for combining two elements with the same type"){
    assert(intSumMonoid.combine(1, 2) == 3)
  }

  test("Monoid has an identity element"){
    assert(intSumMonoid.empty == 0)
  }

  test("Monoid also can be used for combining Options"){
    assert(Monoid[Option[String]].combine(Some("Hola"), Some(" Mundo")).contains("Hola Mundo"))
  }

  test("Monoid should combine n times an element "){
     assert(intSumMonoid.combineN(1, 10) == 10)
  }

  test("Monoid should combine a traversable"){
     assert(intSumMonoid.combineAll(Set(1, 2, 3)) == 6)
  }

  test("A monoid has a iyntax"){
    /* Cats provides syntax for the combine method in the form of the |+| operator.
    Because combine technically comes from Semigroup
    */

    val boo = "Hi " |+| "there" |+| Monoid[String].empty

    assert(boo == "Hi there")

    assert((1 |+| 2) == 3)
  }

}
