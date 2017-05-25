package infra.db.rdsAdapter.dao

import infra.db.rdsAdapter.model.Record
import skinny.orm.SkinnyCRUDMapperWithId

sealed trait DAOWithId[Id,Entity <: Record]
 extends SkinnyCRUDMapperWithId[Id,Entity] {

  override def useSnakeCaseColumnName: Boolean = false

  def toAttributes(record: Entity): Seq[(Symbol,Any)]
}

trait DAOWithInternalGeneratedId[Id,Entity <: Record]
 extends DAOWithId[Id,Entity]
   with InternalGeneratedIdSupport[Id,Entity]

trait DAOWithExternalGeneratedId[Id,Entity <: Record]
 extends DAOWithId[Id,Entity]
  with ExternalIdGeneratedIdSupport[Id,Entity]