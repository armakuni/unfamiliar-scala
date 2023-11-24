// A sealed trait cannot be implemented outside of this file, so the compiler knows all the possible types it could be.
sealed trait IntOrString

// Case classes are special types of classes that have a couple of specific properties:
// 1. They are comparable on value (like records/dataclasses)
// 2. They are intended for matching and destructuring
case class IntValue(i: Int) extends IntOrString
case class StringValue(s: String) extends IntOrString

object CaseClasses extends App {
  private def printIntOrString(x: IntOrString): Unit =
    x match {
      case IntValue(v) => println(s"Int value of $v")
      case StringValue(v) => println(s"String value $v")
    }

  val a = IntValue(42)
  val b = StringValue("foo")

  printIntOrString(a)
  printIntOrString(b)
}
