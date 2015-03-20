package laboratory.globus.components

import com.mongodb.casbah.MongoDB
import laboratory.globus._
import org.scalatest.mock.MockitoSugar
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{Matchers, PropSpec}

class EmployeeServiceTest extends PropSpec with Matchers with TableDrivenPropertyChecks with MockitoSugar
with EmployeeServiceComponent with MongoDBComponent {
  val employeeService: EmployeeService = new EmployeeServiceImpl
  val mongoDB: MongoDB = mock[MongoDB]

  val okSamples = Table("employees",
    Employee(Set(PodKeeper), name = "Vasya"),
    Employee(Set(PodLead), name = "Sasha", email = Some("ok@email.com"))
  )

  val badSamples = Table("employees",
    Employee(Set(), name = "", email = Some("bademail"))
  )

  property("Validation should succeed") {
    forAll(okSamples) { e =>
      val validate = employeeService.validate(e)
      val unit = validate.isSuccess shouldBe true
    }
  }

  property("Validation should fail") {
    forAll(badSamples) { e =>
      val validate = employeeService.validate(e)
      validate.isSuccess shouldBe false
      validate.fold(_.size, _ => 0) shouldBe 3
    }
  }

}
