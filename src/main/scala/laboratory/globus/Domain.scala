package laboratory.globus

case class Pod(employees: Set[Employee],
               parentPod: Option[Pod],
               childPods: Set[Pod],
               linkedPods: Set[Pod],
               name: String,
               wikiUrl: String,
               roadMapUrl: String,
               description: String,
               id: Option[String]) extends Entity

case class Employee(//pod: Pod,
                    roles: Set[Role],
                    location: Option[String] = None,
                    email: Option[String] = None,
                    name: String,
                    bio: Option[String] = None,
                    twitterUrl: Option[String] = None,
                    siteUrl: Option[String] = None,
                    id: Option[String] = None) extends Entity

sealed trait Role
case object PodLead extends Role
case object PodKeeper extends Role
case class CustomRole(name: String) extends Role
case object Admin extends Role
case object Viewer extends Role

trait Entity {
  val id: Option[String]
}