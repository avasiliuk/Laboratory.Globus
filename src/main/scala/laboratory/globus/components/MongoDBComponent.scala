package laboratory.globus.components

import com.mongodb.casbah.MongoDB

trait MongoDBComponent {
  val mongoDB: MongoDB
}
