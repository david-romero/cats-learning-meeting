package exercise2

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits.{catsSyntaxApplicativeError, catsSyntaxEitherId}

import scala.concurrent.TimeoutException
import scala.concurrent.duration.DurationInt


object Timeout3 extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = for {
    done <- timeout(task)
    _ <- done match {
      case Left(_) => IO.delay(println("timeout: won"))
      case Right(_) => IO.delay(println("task: won"))
    }
  } yield ExitCode.Success


  def timeout[A](task: IO[A]): IO[Either[TimeoutException, A]] =
    task.timeout(2.seconds)
      .map(_.asRight[TimeoutException])
      .recover {
        case e : TimeoutException => e.asLeft[A]
      }

  private def task: IO[String] =
    IO.delay(println("Starting task")) *>
    IO.sleep(3.seconds) *>
    IO("Hard work finished") <*
    IO.delay(println("task finished"))

  private def println(msg: String): Unit = Console.println(s"${Thread.currentThread().getName} - ${System.currentTimeMillis()} $msg")
}
