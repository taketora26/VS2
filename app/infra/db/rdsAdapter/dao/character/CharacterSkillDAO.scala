package infra.db.rdsAdapter.dao.character

import infra.db.rdsAdapter.dao.DAOWithExternalGeneratedId
import infra.db.rdsAdapter.model.character.{CharacterSkillRecord, SkillRecord}
import scalikejdbc.{WrappedResultSet, autoConstruct}

trait CharacterSkillDAO extends DAOWithExternalGeneratedId[Int, CharacterSkillRecord]

object CharacterSkillDAO extends CharacterSkillDAO {

  override lazy val defaultAlias = createAlias("cs")

  override lazy val tableName = "character_skill"

  override def idToRawValue(id: Int): Int = id

  override def rawValueToId(value: Any): Int = value.toString.toInt

  override val columnNames = Seq(
    "character_id",
    "skill_id"
  )

  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[CharacterSkillRecord]): CharacterSkillRecord =
    autoConstruct(rs, n)

  override def toAttributes(record: CharacterSkillRecord): Seq[(Symbol, Any)] =
    Seq(
      'character_id -> record.characterId,
      'skill_id -> record.skillId
    )
}