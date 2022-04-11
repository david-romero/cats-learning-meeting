package exercise1

import cats.Applicative
import cats.implicits.{toFunctorOps, toTraverseOps}

class UpTimeService[F[_] : Applicative](client: UpTimeClient[F]) {

  def totalUpTime(hostnames : List[String]) : F[Int] = {
    hostnames.traverse(client.get).map(_.sum)
  }

}
