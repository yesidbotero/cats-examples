package scala.cats

import cats._
import cats.implicits._
import org.scalatest.FunSuite

/*
  Show provides a mechanism for producing developer-friendly console output without using toString
*/

class ShowSuite extends FunSuite {
  test("An Show instance for Int should convert and Int value in a String"){
    val showInt = Show.apply[Int]
    assert(showInt.show(1) == "1")
  }

  test("An show instance can be defined through a function"){
    val showInt = Show.show((x: Int) => x.toString)
    assert(showInt.show(1) == "1")
  }

  test("an show instance should be defined through fromToString"){
    // this instance will use toString object
    val showInt: Show[Int] = Show.fromToString[Int]
    assert(showInt.show(1) == "1")
  }
}
