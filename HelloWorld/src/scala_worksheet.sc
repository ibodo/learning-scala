object Test2 {
  def name: String = "some name"
}

object Test3 {
  def hello(name: String) = {
    "hello" + name
  }
}

Test3.hello(" Sydney")

object Test4 {
  val my_name = "Imre"
  def say_hello(name: String) = {
    name + " say hello to " + my_name
  }
}

Test4.say_hello("Kata")

object O {
  val name = "Oswald"
  val colour = "Black"
  val food = "Milk"
}

object calc {
  def square(arg: Double) : Double = {
    arg*arg
  }
}

calc.square(2.0)

object calc2 {
  def square[A](arg: A)(implicit numeric: Numeric[A]) : A = {
    numeric.times(arg, arg)
  }
}

calc2.square(5)


object Person {
  val firstName = "Jack"
  val lastName = "Black"
}

object alien {
  def greet(p1: Person.type ) : String = {
    "Hi " + p1.firstName
  }
}

alien.greet(Person)

// 2.5 writing methods



