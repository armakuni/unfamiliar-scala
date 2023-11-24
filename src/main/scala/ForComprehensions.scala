import scala.io.StdIn.readLine

object ForComprehensions extends App {
  // This looks like a for-loop, it behaves like a for-loop, but Scala people don't call it a for-loop!
  // This is a for comprehension!
  for (x <- 1 to 10)
    println(x)

  // For comprehensions can return lists by using the yield keyword (this should feel like to Python's comprehensions)
  private val doubles = for (
    x <- 1 to 10
  ) yield x * 2
  println(s"doubles: $doubles")

  // You can have multiple items in a for comprehension
  println("-- cartesian product")
  for (
    x <- List('1', '2', '3');
    y <- List('a', 'b', 'c')
  ) println(s"$x, $y")

  // For comprehensions can have conditions
  println("-- odd numbers")
  for (
    x <- 1 to 10 if x % 2 == 1
  ) println(x)

  // For comprehensions are often not used with list/ranges/sequences at all!
  val name = Some("Tom")
  val language = Some("Scala")
  val goodResult =  for (
    n <- name;
    l <- language
  ) yield s"$n is programming $l"
  println(goodResult)

  // This is useful for error handling:
  // If one of the value in the previous example was None, then it would handled properly
  val noOne = None
  val badResult = for (
    n <- noOne;
    l <- language
  ) yield s"$n is programming $l"
  println(badResult)

  // All of this works because both the List and Option types have the following methods defined on them
  // - map
  // - flatMap
  // - filter
  // For comprehensions are just syntactic sugar for building expressions with these methods.
  // All the above expressions can be rewritten with these methods
  val goodResult2 = name.flatMap(n => language.map(l => s"$n is programming $l"))
  println(s"non-for version: $goodResult2")

  // Very often in Scala, for comprehensions are not about looping, they are about chaining expressions.
  // There are a other types that also work with for comprehensions. These include:
  // - Either: This type is often used like Option but you can specify and error message on failure
  // - Future: Use for async programming to represent something which hasn't completed yet (similar to Promise in JS)

  // Here's a more interesting example

  def getUsername: Either[String, String] = {
    val name = readLine("Username: ")
    if (name.isBlank) {
      Left("Username cannot be blank")
    } else {
      Right(name)
    }
  }

  def getPassword: Either[String, String] = {
    val pw = readLine("Password: ")
    if (pw.isBlank) {
      Left("Password cannot be blank")
    } else {
      Right(pw)
    }
  }

  def login(username: String, password: String): Either[String, String] = {
    if (username == "admin" && password == "password") {
      Right("Welcome message")
    } else {
      Left("Incorrect login details")
    }
  }

  // When you run this the terminal will prompt you for input, try different values and leaving each prompt blank;
  // notice how it short-circuits to the error asap
  val loginResult: Either[String, String] = for (
    user <- getUsername;
    pass <- getPassword;
    message <- login(user, pass)
  ) yield message

  loginResult match {
    case Left(err) => println(s"Login failed: $err")
    case Right(message) => println(s"Login success: $message")
  }

  // So for is basically syntactic sugar for any object that implements map, flatMap and filter.
  // The above example could be written:
  /*
  val loginResult = getUsername.flatMap(user => getPassword.flatMap(pass => login(user, pass)))
  */
}
