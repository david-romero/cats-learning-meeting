package exercise1

import scala.concurrent.Future

trait UpTimeClient {

  def get(hostname : String) : Future[Int]

}
