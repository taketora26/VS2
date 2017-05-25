package infra.db.rdsAdapter.repository

import scalikejdbc.DBSession
import util.ddd.lifecycle.IOContext

case class IOContextOnJDBC(session: DBSession) extends IOContext
