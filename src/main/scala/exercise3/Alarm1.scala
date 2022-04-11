package exercise3

import cats.effect._
import cats.implicits.catsSyntaxTuple2Parallel

import scala.concurrent.duration.DurationInt

object Alarm1 extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    for {
      ticks <- Ref[IO].of(0L)
      _ <- (tickingClock(ticks), beepWhen13(ticks)).parTupled
    } yield ExitCode.Success

  private def tickingClock(ticks: Ref[IO, Long]): IO[Unit] = for {
   _ <- IO.sleep(1.second)
   _ <- ticks.update(_ +1)
   _ <-tickingClock(ticks)
  } yield ()

  private def beepWhen13(ticks: Ref[IO, Long]): IO[Unit] = for {
    t <- ticks.get
    _ <- if (t >= 13) IO.delay(println("BEEP!"))
    else IO.sleep(1.seconds) *> beepWhen13(ticks)
  } yield ()


}
