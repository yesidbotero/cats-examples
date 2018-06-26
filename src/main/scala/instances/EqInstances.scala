package instances
import cats.Eq
import model.Cat
import cats.instances.int._
import cats.instances.string._
import cats.syntax.eq._

object EqInstances {
  implicit val eqCat = new Eq[Cat] {
    override def eqv(x: Cat, y: Cat): Boolean = {
      x.color === y.color && x.age === y.age && x.name === y.name
    }
  }
}
