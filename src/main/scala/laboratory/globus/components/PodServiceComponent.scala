package laboratory.globus.components

import laboratory.globus.Pod

import scalaz.ValidationNel

trait PodServiceComponent {
  this: MongoDBComponent =>

  val podService: PodService

  trait PodService extends Service[Pod] {
    def linkPods(pod1: Pod, pod2: Pod): (Pod, Pod)
  }

  class PodServiceImpl extends PodService {
    override def linkPods(pod1: Pod, pod2: Pod): (Pod, Pod) = ???
    override def delete(entity: Pod*): ValidationNel[String, Pod] = ???
    override def validate(entity: Pod): ValidationNel[String, Pod] = ???
    override def save(entity: Pod): ValidationNel[String, Pod] = ???
    override def find(filter: (Pod) => Boolean): Option[List[Pod]] = ???
  }

}
