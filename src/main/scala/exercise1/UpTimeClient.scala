package exercise1

trait UpTimeClient[F[_]] {

  def get(hostname : String) : F[Int]

}
