package infra.db.rdsAdapter.model.character

import infra.db.rdsAdapter.model.Record

case class CharacterSkillRecord(
                                 characterId: Int,
                                 skillId: Int
                               ) extends Record