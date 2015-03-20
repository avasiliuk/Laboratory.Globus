package laboratory.globus.components

import laboratory.globus.Entity

import scalaz.ValidationNel

trait Service[T <: Entity] {
  def validate(entity: T): ValidationNel[String, T]
  def save(entity: T): ValidationNel[String, T]
  def delete(entity: T*): ValidationNel[String, T]
  def find(filter: (T) => Boolean): Option[List[T]]
}


