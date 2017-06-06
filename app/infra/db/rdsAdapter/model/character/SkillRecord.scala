package infra.db.rdsAdapter.model.character

import infra.db.rdsAdapter.model.Record

case class SkillRecord(
                        id: Int,
                        skill: String
                      ) extends Record
