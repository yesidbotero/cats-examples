package typeclasses

trait Printable[A] {
  def format(value: A): String
}
