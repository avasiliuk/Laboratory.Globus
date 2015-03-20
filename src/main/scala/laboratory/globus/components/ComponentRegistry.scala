package laboratory.globus.components

import com.mongodb.casbah.{MongoClient, MongoDB}

object ComponentRegistry extends PodServiceComponent
with EmployeeServiceComponent
with MongoDBComponent {
  val podService = new PodServiceImpl
  val employeeService = new EmployeeServiceImpl
  val mongoDB: MongoDB = MongoClient("localhost", 27017)("globus")

}
