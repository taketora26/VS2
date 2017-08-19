package domain.lifecycle.chracter

import util.ddd.lifecycle.{IOContext, Repository}
import domain.model.chracter.CharacterId
import domain.model.chracter.Character

import scala.util.Try

trait CharacterRepository extends Repository[CharacterId,Character]{

 // def store(entity: Character)(implicit ctx: IOContext): Try[Unit]

 // def resolveBy(id: CharacterId)(implicit ctx: IOContext): Try[Character]

  def resolveAll()(implicit ctx: IOContext): Try[Seq[Character]]

 // def deleteBy(id: CharacterId)(implicit ctx: IOContext): Try[Unit]

}
