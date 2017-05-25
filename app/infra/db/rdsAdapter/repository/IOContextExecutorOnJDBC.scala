package infra.db.rdsAdapter.repository

import infra.db.rdsAdapter.exception.NoDBSessionException
import scalikejdbc.{DBSession, NoSession}
import util.ddd.lifecycle.{IOContext => IOContextBase}

import scala.util.{Failure, Try}

class IOContextExecutorOnJDBC {

  def execute[A](func:DBSession => A)(implicit ctx: IOContextBase):Try[A] = ctx match {
    case IOContextOnJDBC(NoSession) =>
      Failure(new NoDBSessionException)
    case IOContextOnJDBC(session) =>
      Try(func(session))
  }
}

object IOContextExecutorOnJDBC extends IOContextExecutorOnJDBC