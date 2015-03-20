package laboratory.globus.components

import laboratory.globus.{Employee, Role}

import scalaz.Scalaz._
import scalaz.ValidationNel

trait EmployeeServiceComponent {
  this: MongoDBComponent =>

  private lazy val coll = mongoDB("employees")
  val employeeService: EmployeeService
  trait EmployeeService extends Service[Employee] {
  }

  class EmployeeServiceImpl extends EmployeeService {
    override def save(t: Employee): ValidationNel[String, Employee] = {
      ???
    }
    override def delete(t: Employee*): ValidationNel[String, Employee] = ???
    override def find(filter: (Employee) => Boolean): Option[List[Employee]] = ???
    override def validate(entity: Employee): ValidationNel[String, Employee] = {
      val vEmail: ValidationNel[String, Option[String]] = entity.email match {
        case Some(s) => if (s.matches( """(\w|\.)+@\w+\.\w+""")) Some(s).successNel[String] else s"Invalid email $s".failureNel[Option[String]]
        case None => None.successNel[String]
      }
      val vName: ValidationNel[String, String] =
        if (entity.name.isEmpty) "Name could not be empty".failureNel[String]
        else entity.name.successNel[String]
      val vRoles: ValidationNel[String, Set[Role]] =
        if (entity.roles.isEmpty) "At least one role should be set".failureNel[Set[Role]]
        else entity.roles.successNel[String]
      (vName |@| vRoles |@| vEmail)((_, _, _) => entity)
    }
  }

}
