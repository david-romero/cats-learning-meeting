package exercise1

import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class UpTimeServiceSpec  extends AnyFunSpec
  with BeforeAndAfter
  with Matchers {

  val upTimeService : UpTimeService = ???


  describe("Given three hosts"){
    describe("When the total up time is calculated"){
      it("should return the sum of all up times"){
        // given
        val hosts = List("host1", "host2", "host3")

        // when
        val totalUpTime = upTimeService.totalUpTime(hosts)

        // then
        totalUpTime shouldBe 9
      }
    }
  }

}
