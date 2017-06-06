package infra.db.rdsAdapter.dao.character

import infra.db.rdsAdapter.dao.DAOWithExternalGeneratedId
import infra.db.rdsAdapter.model.character.SkillRecord
import scalikejdbc.{WrappedResultSet, autoConstruct}

trait SkillDAO extends DAOWithExternalGeneratedId[Int, SkillRecord]

object SkillDAO extends SkillDAO {

  override lazy val defaultAlias = createAlias("s")

  override lazy val tableName = "skill"

  override def idToRawValue(id: Int): Int = id

  override def rawValueToId(value: Any): Int = value.toString.toInt

  override val columnNames = Seq(
    "id",
    "skill"
  )

  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[SkillRecord]): SkillRecord =
    autoConstruct(rs, n)

  override def toAttributes(record: SkillRecord): Seq[(Symbol, Any)] =
    Seq(
      'id -> record.id,
      'skill -> record.skill
    )
}
