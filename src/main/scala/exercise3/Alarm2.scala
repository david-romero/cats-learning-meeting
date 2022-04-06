package exercise3

import cats.effect._

object Alarm2 extends IOApp{
  override def run(args: List[String]): IO[ExitCode] =
    for {
      ticks <- Ref[IO].of(0L)
      is13 <- Deferred[IO, Unit]
    } yield ExitCode.Success



}
