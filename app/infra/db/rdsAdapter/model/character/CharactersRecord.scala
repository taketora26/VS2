package infra.db.rdsAdapter.model.character

import infra.db.rdsAdapter.model.Record
import org.joda.time.DateTime

case class CharactersRecord(
                             id: Int,
                             name: String,
                             fullName: String,
                             realName: String,
                             roleId: Int,
                             imageUrl: String,
                             createdAt: DateTime,
                             updatedAt: DateTime
                           ) extends Record
