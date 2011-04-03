package gemfire

/**
 * Created by Bastian Echterhoelter
 * Date: 3/24/11
 * Time: 23:20
 */

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import com.gemstone.gemfire.cache.{CacheFactory, Cache}

@RunWith(classOf[JUnitRunner])
class HelloGemfireSuite extends FunSuite with ShouldMatchers with BeforeAndAfterEach {

  val cache:Cache  = new CacheFactory
      .set("locators", "localhost[55221]")
      .set("mcast-port", "0")
      .set("log-level", "error")
      .create();

  override def beforeEach() {
  }

  override def afterEach() {
  }

  test("Initial gemfire test") {





  }
}