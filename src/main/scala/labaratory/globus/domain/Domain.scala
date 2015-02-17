package labaratory.globus.domain

import scala.collection.Set

case class Pod(employees: Set[Employee],
               parentPod: Option[Pod],
               childPods: Set[Pod],
               linkedPods: Set[Pod],
               name: String,
               wikiUrl: String,
               roadMapUrl: String,
               description: String)

case class Employee(pod: Pod,
                    roles: Set[Role],
                    location: String,
                    email: String,
                    name: String,
                    bio: String,
                    twitterUrl: String,
                    siteUrl: String)

sealed trait Role
case class PodLead() extends Role
case class PodKeeper() extends Role
case class CustomRole(name: String) extends Role
case class Admin() extends Role
case class Viewer() extends Role

