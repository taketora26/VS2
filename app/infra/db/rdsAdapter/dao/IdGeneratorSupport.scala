package infra.db.rdsAdapter.dao

import skinny.orm.SkinnyCRUDMapperWithId

trait InternalGeneratedIdSupport[Id,Entity] {
  self: SkinnyCRUDMapperWithId[Id,Entity] =>

  override def useAutoIncrementPrimaryKey: Boolean = true

  override def useExternalIdGenerator: Boolean = false

}

trait ExternalIdGeneratedIdSupport[Id,Entity] {
  self: SkinnyCRUDMapperWithId[Id,Entity] =>

  override def useAutoIncrementPrimaryKey: Boolean = false

  override def useExternalIdGenerator: Boolean = true

}
