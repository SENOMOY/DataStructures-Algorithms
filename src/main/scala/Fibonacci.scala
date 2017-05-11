import scala.annotation.tailrec

/**
  * Created by subhajit.sen on 08-05-2017.
  */

object Fibonacci extends App {

  println(fib(9))

  // tail recursion
  def fib(x: Int): BigInt = {
    @tailrec
    def fibHelper(x: Int, prev: BigInt = 0, next: BigInt = 1): BigInt = x match {
      case 0 => prev
      case 1 => next
      case _ => fibHelper(x - 1, next, (next + prev))
    }

    fibHelper(x)
  }
}