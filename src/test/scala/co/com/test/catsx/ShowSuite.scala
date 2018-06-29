package co.com.test.catsx

import cats._
import cats.implicits._
import org.scalatest.FunSuite

/*
  Show provides a mechanism for producing developer-friendly console output without using toString
*/

class ShowSuite extends FunSuite {
  test("The method apply of Show return an instance for type supplied"){
    /* In this case, the method apply requires an implicit monoid (the compiler resolves the implicit) 
      and return it 
    */
    val floatShow: Show[Float] = Show.apply[Float]
    assert(floatShow.isInstanceOf[Show[Float]])
  }


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
