package exercise3

import cats.effect._

object Alarm1 extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    for {
      ticks <- Ref[IO].of(0L)
    } yield ExitCode.Success


}
