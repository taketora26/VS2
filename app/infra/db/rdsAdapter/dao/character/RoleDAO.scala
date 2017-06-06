package infra.db.rdsAdapter.dao.character

import infra.db.rdsAdapter.dao.DAOWithExternalGeneratedId
import infra.db.rdsAdapter.model.character.RoleRecord
import scalikejdbc.{WrappedResultSet, autoConstruct}

trait RoleDAO extends DAOWithExternalGeneratedId[Int, RoleRecord]

object RoleDAO extends RoleDAO {

  override lazy val defaultAlias = createAlias("r")

  override lazy val tableName = "role"

  override def idToRawValue(id: Int): Int = id

  override def rawValueToId(value: Any): Int = value.toString.toInt

  override val columnNames = Seq(
    "id",
    "name",
    "created_at",
    "updated_at"
  )

  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[RoleRecord]): RoleRecord =
    autoConstruct(rs, n)

  override def toAttributes(record: RoleRecord): Seq[(Symbol, Any)] =
  Seq(
    'id -> record.id,
    'name -> record.name,
    'created_at -> record.createdAt,
    'updated_at -> record.updatedAt
  )

}
