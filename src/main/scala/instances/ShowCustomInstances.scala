package instances
import model.Cat
import cats.Show
import cats.instances.string._
import cats.instances.int._
import cats.syntax.show._

object ShowCustomInstances {
  implicit val catShow = new Show[Cat] {
    override def show(t: Cat): String = s"${t.name.show} is a ${t.age.show} year-old ${t.color.show} cat"
  }
}
