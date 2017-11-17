//3.5

// 3.5 pattern matching

object Stormtrooper {
  def inspect(person: Person2): String =
    person match {
      case Person2("Luke", "Skywalker") => "Stop, rebel scum!"
      case Person2("Han", "Solo") => "Stop, rebel scum!"
      case Person2(first, last) => s"Move along, $first"
    }
}

Stormtrooper.inspect(Person2("Noel", "Walsh"))
Stormtrooper.inspect(Person2("Han", "Solo"))

//3.4.5

case class CaseCat(colour: String, food: String, name: String){
}



//3.4

case class Person2(firstName: String, lastName: String){
  def name(): String = firstName + " " + lastName
}
object Person2 {
  def apply(wholeName: String): Person2 = {
    val parts = wholeName.split(" ")
    new Person2(parts(0), parts(1))
  }
}
val janeDoe = Person2("Jane", "Doe")
val johnDoe = Person2("John Doe")
johnDoe.name()

// 3.1.6.6
class Adder(amount: Int){
  // function application syntax, can leave the apply keyword
  def apply(in: Int) = in + amount
}
new Adder(2)(3)

// 3.1.6.4
case class Counter(count: Int = 0){
  def inc(v: Int = 1): Counter = this.copy(count+v)
  def dec(v: Int = 1): Counter = this.copy(count-v)
  // 3.1.6.6
  def adjust(adder: Adder) : Counter =
    this.copy(count + adder(0))
}
Counter(10).inc().dec().inc().inc().count
Counter(10).adjust(new Adder(1)).count

// 3.1.6.3
case class Director(
              firstName: String
              ,lastName: String
              ,yearOfBirth: Int
              ){
  def name(): String = firstName + " " + lastName
}

case class Film(
                 name: String
                 , yearOfRelease: Int
                 , imdbRating: Double
                 , director: Director
          ){
  def directorsAge(): Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(who: Director) : Boolean = if(who == director) true else false
}

val eastwood = Director("Clint", "Eastwood", 1930)
val mcTiernan = Director("John", "McTiernan", 1951)
val nolan = Director("Christopher", "Nolan", 1970)
val someBody = Director("Just", "Some Body", 1990)
val memento = Film("Memento", 2000, 8.5, nolan)
val darkKnight = Film("Dark Knight", 2008, 9.0, nolan)
val inception = Film("Inception", 2010, 8.8, nolan)
val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales = Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven = Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino = Film("Gran Torino", 2008, 8.2, eastwood)
val invictus = Film("Invictus", 2009, 7.4, eastwood)
val predator = Film("Predator", 1987, 7.9, mcTiernan)
val dieHard = Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)
eastwood.yearOfBirth // should be 1930
dieHard.director.name() // should be "John McTiernan"
invictus.isDirectedBy(nolan) // should be false

highPlainsDrifter.copy(name = "L'homme des hautes plaines")
// returns Film("L'homme des hautes plaines", 1973, 7.7, /* etc */)
thomasCrownAffair.copy(yearOfRelease = 1968,
  director = Director("Norman", "Jewison", 1926))
// returns Film("The Thomas Crown Affair", 1926, /* etc */)
inception.copy().copy().copy()
// returns a new copy of `inception`

// 3.5.3.2
object Dad {
  def rate(film: Film) =
    film match{
      case Film(_,_,_,Director(_,"Eastwood",_)) => 10.0
      case Film(_,_,_,Director("John", "McTiernan", _)) => 7.0
      case Film(_,_,_,_) => 3.0
    }
}

Dad.rate(unforgiven)
Dad.rate(predator)
Dad.rate(memento)

// 3.1.6.1
case class Cat(
           name: String
           , color: String
           , food: String
         ) {

}

val oswald = Cat(name = "Oswald", color = "Black", food = "Milk")
val henderson = Cat("Henderson", "Ginger", "Chips")
val quentin = Cat("Quentin", "Tabby and white", "Curry")

// 3.1.6.2
object ChipShop {
  def serve(who : Cat): Boolean = {
    if(who.food == "Chips")
      true
    else
      false
  }
  def willServe(cat: Cat): Boolean =
    cat match {
      case Cat(_, _, "Chips") => true
      case Cat(_,_,_) => false
    }
}
ChipShop.serve(oswald)
ChipShop.serve(henderson)
ChipShop.serve(quentin)
ChipShop.willServe(oswald)
ChipShop.willServe(henderson)
ChipShop.willServe(quentin)


class C( val first : String = "something", val second : String = "other stuff" ) {
  def do_stuff(in : String = "stuff") : String =
    "hello, I'll do " + in + " with " + first + " " + second
}

val c = new C(first = "second" , second = "first")
c.do_stuff("arst")
// constructor args with val keywords are automatically defined as fields
class Person(val firstName: String, val lastName: String) {
  def name = firstName + " " + lastName
}

val noel = new Person("Noel", "Welsh")
noel

class Alien {
  def greet(p: Person) = {
    "Hello " + p.name + "!"
  }
}

val alien1 = new Alien
alien1.greet(noel)

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
  def square(in: Double) : Double = in*in
  def cube(in: Double) : Double = in*square(in)
}

calc.square(2.0)
calc.cube(3.0)
assert(calc.cube(3.0) == 27.0)
assert(assertion = calc.cube(-3.0) == -27.0)

object calc2 {
  def square[A](arg: A)(implicit numeric: Numeric[A]) : A = {
    numeric.times(arg, arg)
  }
}

calc2.square(5)

object objectPerson {
  val firstName = "Jack"
  val lastName = "Black"
}

object alien {
  def greet(p1: objectPerson.type ) : String = {
    "Hi " + p1.firstName
  }
}

alien.greet(objectPerson)

if(1>2) "alien" else "predator"
if(1>2) "alien" else 12
if(false) "hello"
