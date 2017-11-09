
object HelloWorld {
  def main(args: Array[String]): Unit = {
    for (i: Int <- 1 to 5) {
      println("hello world " + i)
    }
  }
}