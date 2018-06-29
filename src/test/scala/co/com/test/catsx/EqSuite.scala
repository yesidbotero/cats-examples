package co.com.test.catsx

import cats.Eq
import cats.instances.int._
import cats.instances.option._
import org.scalatest.FunSuite



 /* Eq is designed to support type-safe equality and address annoyances using Scala’s built-in == operator. */

class EqSuite extends FunSuite {

  val eqInt = Eq.apply[Int]
  val eqOptionInt: Eq[Option[Int]] = Eq.apply[Option[Int]]


  test("An Eq instance for a specific type compares two elements of same type"){
    assert(eqInt.eqv(1, 1))
    assert(!eqInt.eqv(1, 5))
  }

  test("An Eq instance for a specific type does not compare two elements of different types"){
    assertDoesNotCompile("eqInt.env(1, 'One')")
  }

  test("Eq also can be used with Option"){
    assert(eqOptionInt.eqv(Option(1), Option(1)))
    assert(!eqOptionInt.eqv(Option(2), Option(1)))
  }

  test("Eq also can be used with Option subtypes"){
    assertDoesNotCompile("assertDoesNotCompile(eqOptionInt.eqv(Option(2), Some(2)))")
    /* We have to re-type the arguments  */
    assert(eqOptionInt.eqv(Option(1), Some(1): Option[Int]))
  }



}
