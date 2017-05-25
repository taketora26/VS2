package infra.db.rdsAdapter.exception

import util.ddd.exception.BaseException

class RDBBaseException(message: String, cause: Option[Throwable] = None)
 extends BaseException(message, cause.orNull){

  def this(message:String, cause: Throwable) = this(message,Some(cause))
}
