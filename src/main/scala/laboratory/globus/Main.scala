package laboratory.globus

import com.mongodb.casbah.Imports._
import laboratory.globus.components.ComponentRegistry

object Main {
  def main(args: Array[String]) {
    ComponentRegistry.mongoDB("test").insert(MongoDBObject("test" -> "test"))
  }
}
