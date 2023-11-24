object InfixNotation {
  class Response(private val statusCode: Int, private val body: String = "") {
    def withBody(newBody: String): Response = new Response(statusCode, newBody)

    override def toString = s"Response(statusCode=$statusCode, body=$body)"
  }

  def main(args: Array[String]): Unit = {
    val response1 = new Response(200)
    println(s"response1 = $response1")

    val response2 = response1.withBody("response2 body")
    println(s"response2: $response2")

    // In Scala, you can use single argument methods as infix functions.
    // That is, you can omit the dot and parens.
    val response3 = response1 withBody "response3 body"
    println(s"response3 = $response3")

    // The reason for this is because everything an object in Scala
    val a = 2 + 2
    val b = 2.+(2)
    print(s"$a == $b")
  }
}
