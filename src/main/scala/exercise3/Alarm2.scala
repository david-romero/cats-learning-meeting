package exercise3

import cats.effect._

import scala.concurrent.duration.DurationInt

object Alarm2 extends IOApp{
  override def run(args: List[String]): IO[ExitCode] =
    for {
      ticks <- Ref[IO].of(0L)
      is13 <- Deferred[IO, Unit]
      _ <- (beepWhen13(is13), tickingClock(ticks, is13)).parTupled
    } yield ExitCode.Success

  def beepWhen13(is13: Deferred[IO, Unit]): IO[Unit] = for {
    _ <- is13.get
    _ <- IO.delay(println("BEEP!"))
  } yield ()


  def tickingClock(ticks: Ref[IO, Long], is13: Deferred[IO, Unit]): IO[Unit] = for {
    _ <- IO.sleep(1.second)
    _ <- IO.delay(println(System.currentTimeMillis))
    count <- ticks.updateAndGet(_ + 1)
    _ <- if (count >= 13) is13.complete(()) else IO.unit
    _ <- tickingClock(ticks, is13)
  } yield ()

}
