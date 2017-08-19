package infra.db.rdsAdapter

import infra.db.rdsAdapter.repository.IOContextOnJDBC
import scalikejdbc.{AutoSession, DB}
import util.ddd.lifecycle.{IOContext, IOContextManager}

class IOContextManagerOnJDBC extends IOContextManager {

  override def context: IOContext = IOContextOnJDBC(AutoSession)

  def transactionalContext[T](execution: (IOContext) => T): T = {
    DB.localTx { session =>
      execution(IOContextOnJDBC(session))
    }
  }
}
