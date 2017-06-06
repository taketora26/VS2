package infra.db.rdsAdapter.model.character

import infra.db.rdsAdapter.model.Record
import org.joda.time.DateTime

case class RoleRecord (
                 id: Int,
                 name: String,
                 createdAt: DateTime,
                 updatedAt: DateTime
               ) extends Record
