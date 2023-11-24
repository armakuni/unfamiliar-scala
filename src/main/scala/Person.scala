class Person(val name: String)

object Person {
  // The scope of a companion object is one place implicit will look when trying to find a value to supply to a function
  implicit val defaultPerson: Person = new Person("Colonel Mustard")
}
