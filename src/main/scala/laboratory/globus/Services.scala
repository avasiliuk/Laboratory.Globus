package laboratory.globus

trait Service[T] {
  def save(t: T)
  def delete(t: T*)
  def find(filter: (T) => Boolean): List[T]
}

trait PodService extends Service[Pod] {
  def linkPods(pod1: Pod, pod2: Pod): (Pod, Pod)
}

trait EmployeeService extends Service[Employee] {
}


