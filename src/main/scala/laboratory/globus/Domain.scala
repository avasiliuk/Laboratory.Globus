package laboratory.globus

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
case object PodLead extends Role
case object PodKeeper extends Role
case class CustomRole(name: String) extends Role
case object Admin extends Role
case object Viewer extends Role
