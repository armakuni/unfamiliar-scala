import ImplicitDefinitions._

object Implicits extends App {
  // implicit is a weird, overloaded keyword in Scala. Depending on where it is written, it has a different meaning.
  // In can be used to:

  // 1. Define an implicit parameter to a function
  def iAcceptAnImplicit(implicit x: Int): Unit = println(s"x = $x")

  // 2. Define an implicit value in scope
  implicit val someInt: Int = 5

  // 3. Define an extension method in a class
  implicit class IntPrinter(x: Int) {
    def customPrint(): Unit = {
      println(s"CUSTOM PRINT [$x]")
    }
  }

  // Time to see it in action:
  // With function arguments, Scala will automatically supply the implicit values by type. Here it looks for an implicit Int in
  // scope; in this case we defined someInt above, but there are other places scala will look if one is not
  // found in local scope.
  iAcceptAnImplicit

  // (did I mention that you don't need parens to call a function with no arguments?)

  // Extension methods are added to the type which is supplied as the "constructor argument" to the implicit class.
  // The IntPrinter above has added customPrint to all Ints
  5.customPrint()

  // WTF right?!

  // Here's another example of a function which uses implicits
  def mysteriousImplicits(implicit person: Person, message: String): Unit = {
    message.sayTo(person)
  }

  // Implicits can get even more confusing when you don't know where they came from. Work out how this is working...
  mysteriousImplicits

  // Note, better tooling (i.e. IntelliJ / powerful editor plugins) will make it easier to locate implicit values used,
  // but don't necessarily help you know what to import if you want to use one and don't know where it is.
}
