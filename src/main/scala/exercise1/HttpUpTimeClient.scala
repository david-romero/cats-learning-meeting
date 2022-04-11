package exercise1

import cats.effect.IO

import scala.concurrent.Future

class HttpUpTimeClient extends UpTimeClient[Future]{
  override def get(hostname: String): Future[Int] = ???
}

class IOHttpClientClient extends UpTimeClient[IO]  {

  val delegate : UpTimeClient[Future] = new HttpUpTimeClient

  override def get(hostname: String): IO[Int] = IO.fromFuture(IO(delegate.get(hostname)))
}
