package infra.db.rdsAdapter.dao.character

import infra.db.rdsAdapter.dao.DAOWithExternalGeneratedId
import infra.db.rdsAdapter.model.character.CharactersRecord
import scalikejdbc._

trait CharactersDAO extends DAOWithExternalGeneratedId[Int, CharactersRecord]

object CharactersDAO extends CharactersDAO {

  override lazy val defaultAlias = createAlias("c")

  override lazy val tableName = "characters"

  override def idToRawValue(id: Int): Int = id

  override def rawValueToId(value: Any): Int = value.toString.toInt

  override val columnNames = Seq(
    "id",
    "name",
    "full_name",
    "real_name",
    "role_id",
    "image_url",
    "created_at",
    "updated_at"
  )

  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[CharactersRecord]): CharactersRecord =
    autoConstruct(rs, n)

  override def toAttributes(record: CharactersRecord): Seq[(Symbol, Any)] =
    Seq(
      'id -> record.id,
      'name -> record.name,
      'full_name -> record.fullName,
      'real_name -> record.realName,
      'role_id -> record.roleId,
      'image_url -> record.imageUrl,
      'created_at -> record.createdAt,
      'updated_at -> record.updatedAt
    )
}