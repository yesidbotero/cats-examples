package model

final case class Cat(name: String, age: Int, color: String)

// Exercise: Branching out with Functors

sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]