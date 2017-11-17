import java.util.Date

trait Visitor {
  def id: String
  def createdAt: Date
  def age: Long = new Date().getTime - createdAt.getTime
}
case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitor

case class User(
               id: String,
               email: String,
               createdAt: Date = new Date()
               ) extends Visitor


// 4.1.4

trait Feline {
  def color: String
  def sound: String = "roar"
}

case class Cat(name: String, favoriteFood: String, color: String)
extends Feline {
  override val sound: String = "meow"
}
case class Lion(name: String, maneSize: Int, color: String)
extends Feline {}
case class Tiger(name: String, color: String)
extends Feline {}
case class Panther(name: String, color: String)
extends Feline {}


trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double

  override def toString: String = {
    "area: " + area +
    "\nperimeter: " + perimeter +
    "\nsides: " + sides
  }
}

case class Circle(radius: Double) extends Shape{
  def sides = 0
  override def perimeter: Double = radius*2*math.Pi
  override def area: Double = radius*radius*math.Pi
}
case class Triangle(a: Double) extends Shape{
  def sides = 3
  override def perimeter: Double = 3*a
  override def area: Double = math.sin(math.toRadians(60))/2 * math.pow(a, 2)
}

trait Rectangular extends Shape {
  def sides = 4
}

case class Rectangle(a: Double, b: Double) extends Rectangular {
  override def perimeter: Double = 2*a + 2*b
  override def area: Double = a*b
}
case class Square(a: Double) extends Rectangular {
  override def perimeter: Double = 4*a
  override def area: Double = a*a
}

Circle(1)
Triangle(2)
Rectangle(5, 8)
Square(5)

