import scala.annotation.tailrec

/**
  * Created by subhajit.sen on 12-05-2017.
  */
object Factorial extends App {

  println(s"Regualar Recursive ${factorial1(5)}")
  println(s"Tail Recursive ${factorial2(5)}")

  // 1 - basic recursive factorial method
  def factorial1(n: Int): Int = {
    if (n == 0) 1
    else n * factorial1(n - 1)
  }

  // 2 - tail-recursive factorial method
  def factorial2(n: Long): Long = {
    @tailrec
    def factorialAccumulator(acc: Long, n: Long): Long = {
      if (n == 0) acc
      else factorialAccumulator(n * acc, n - 1)
    }

    factorialAccumulator(1, n)
  }
}
