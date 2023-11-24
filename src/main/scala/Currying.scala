object Currying {
  // In Scala you can define functions with multiple argument lists...
  def add(value1: Int)(value2: Int): Int = value1 + value2

  def main(args: Array[String]): Unit = {
    // So that they can be partially applied with values
    val increment: Int => Int = add(1)
    val addTwo: Int => Int = add(2)

    println(s"Incrementing 5: ${increment(5)}")
    println(s"Adding 2 to 14: ${addTwo(14)}")
  }
}
