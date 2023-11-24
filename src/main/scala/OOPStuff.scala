// Traits are basically interfaces
trait Greeter {
  def greet(): Unit

  // But can have default implementations
  def greetAlternative(): Unit = {
    println("I'm not exciting enough to have a second greeting")
  }
}

class Dog(val name: String) extends Greeter {
  override def greet(): Unit = {
    println(s"Woof from $name")
  }
}

// Objects are like static class in Java, there is only one instance.
// If an instance has the same name as a class it is called a Companion Object.
object Dog {
  def printDescription(): Unit = println("Four legged creature that says woof")

  // apply is a special function in Scala, when it is defined on a object, you can invoke it by just putting parens on
  // on the object. By adding it to a companion object like this, you can have Python like object construction. See
  // animal1 below
  def apply(name: String): Dog = new Dog(name)
}

class Cat(val name: String) extends Greeter {
  override def greet(): Unit = println(s"Meow from $name")

  override def greetAlternative(): Unit = println(s"Obey me human!")
}

object OOPStuff extends App {
  Dog.printDescription()

  private def printGreetings(greeter: Greeter): Unit = {
    greeter.greet()
    greeter.greetAlternative()
  }

  println("--- animal1")
  // new is not used here so it uses the apply function in the Dog companion object
  private val animal1 = Dog("Bob")
  printGreetings(animal1)

  println("--- animal2")
  private val animal2 = new Cat("Garfield")
  printGreetings(animal2)

  println("--- animal3")
  // You can override methods of a class when you create it
  private val animal3: Greeter = new Dog("Westwood") {
    override def greetAlternative(): Unit = print("Woof from Big Dawg!")
  }
  printGreetings(animal3)
}

