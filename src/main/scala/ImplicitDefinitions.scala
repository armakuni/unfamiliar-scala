object ImplicitDefinitions {
  // When this gets imported, it will be used as an implicit String
  implicit val defaultString: String = "you whacked them with the candle stick!"

  // If this is imported, then you can call .sayTo on Strings
  implicit class StringPersonPrinter(s: String) {
    def sayTo(person: Person): Unit = {
      println(s"Hey ${person.name}, $s")
    }
  }
}
