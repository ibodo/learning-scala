//3.4

class Person2(val firstName: String, val lastName: String){
  def name(): String = firstName + " " + lastName
}
object Person2 {
  def apply(wholeName: String): Person2 = {
    val parts = wholeName.split(" ")
    new Person2(parts(0), parts(1))
  }
}
val johnDoe = Person2("John Doe")
johnDoe.name()

// 3.1.6.6
class Adder(amount: Int){
  // function application syntax, can leave the apply keyword
  def apply(in: Int) = in + amount
}
new Adder(2)(3)

// 3.1.6.4
class Counter(val count: Int){
  def inc(v: Int = 1): Counter = new Counter(count+v)
  def dec(v: Int = 1): Counter = new Counter(count-v)
  // 3.1.6.6
  def adjust(adder: Adder) : Counter =
    new Counter(count + adder(0))
}
new Counter(10).inc().dec().inc().inc().count
new Counter(10).adjust(new Adder(1)).count

// 3.1.6.3
class Director(
              val firstName: String
              ,val lastName: String
              ,val yearOfBirth: Int
              ){
  def name(): String = firstName + " " + lastName
}

object Director {
  def apply(firstName: String
    ,lastName: String
    ,yearOfBirth: Int
  ): Director = new Director(firstName, lastName, yearOfBirth)

  def older(one: Director, other: Director): Director = {
    if (one.yearOfBirth < other.yearOfBirth)
      one
    else
      other
  }
}

class Film(
          val name: String
          ,val yearOfRelease: Int
          ,val imdbRating: Double
          ,val director: Director
          ){
  def directorsAge(): Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(who: Director) : Boolean = if(who == director) true else false
  def copy(
          name: String = name
          ,yearOfRelease: Int = yearOfRelease
          ,imdbRating: Double = imdbRating
          ,director: Director = director
          ) = new Film(name, yearOfRelease, imdbRating, director)

  override def toString: String = {
    "\nname: " + name +
    "\nyearOfRelease: " + yearOfRelease +
    "\nimdbRating: " + imdbRating +
    "\ndirector: " + director.name()
  }
}

object Film {
  def apply(
             name: String
            ,yearOfRelease: Int
            ,imdbRating: Double
            ,director: Director
           ): Film = new Film(name, yearOfRelease, imdbRating, director)
  def highestRating(one: Film, other: Film): Double = {
    if(one.imdbRating < other.imdbRating)
      other.imdbRating
    else
      one.imdbRating
  }
  def oldestDirectorAtTheTime(one: Film, other: Film): Director = {
    if(one.director.yearOfBirth < other.director.yearOfBirth)
      one.director
    else
      other.director
  }
}


val eastwood = new Director("Clint", "Eastwood", 1930)
val mcTiernan = new Director("John", "McTiernan", 1951)
val nolan = new Director("Christopher", "Nolan", 1970)
val someBody = new Director("Just", "Some Body", 1990)
val memento = new Film("Memento", 2000, 8.5, nolan)
val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
val inception = new Film("Inception", 2010, 8.8, nolan)
val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus = new Film("Invictus", 2009, 7.4, eastwood)
val predator = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)
eastwood.yearOfBirth // should be 1930
dieHard.director.name() // should be "John McTiernan"
invictus.isDirectedBy(nolan) // should be false

highPlainsDrifter.copy(name = "L'homme des hautes plaines")
// returns Film("L'homme des hautes plaines", 1973, 7.7, /* etc */)
thomasCrownAffair.copy(yearOfRelease = 1968,
  director = new Director("Norman", "Jewison", 1926))
// returns Film("The Thomas Crown Affair", 1926, /* etc */)
inception.copy().copy().copy()
// returns a new copy of `inception`


// 3.1.6.1
class Cat(
           val name: String
           , val color: String
           , val food: String
         ) {

}

val oswald = new Cat(name = "Oswald", color = "Black", food = "Milk")
val henderson = new Cat("Henderson", "Ginger", "Chips")
val quentin = new Cat("Quentin", "Tabby and white", "Curry")

// 3.1.6.2
object ChipShop {
  def serve(who : Cat): Boolean = {
    if(who.food == "Chips")
      true
    else
      false
  }
}
ChipShop.serve(oswald)
ChipShop.serve(henderson)
ChipShop.serve(quentin)



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
