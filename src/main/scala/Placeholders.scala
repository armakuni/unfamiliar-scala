object Placeholders extends App {
  // Scala has a familiar lambda function syntax
  println(List(1, 2, 3).map(x => x + 1))

  // It also has a even shorter version where you can just use _ as a place holder
  println(List(1, 2, 3).map(_ + 1))

  // If you put multiple _ in then it will consume each argument in order
  println(List(1, 3, 4).reduce(_ - _))
}
