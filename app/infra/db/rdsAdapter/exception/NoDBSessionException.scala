package infra.db.rdsAdapter.exception

class NoDBSessionException(cause: Option[Throwable] = None) extends {
  val message = "有効なデータベースのセッションが存在しません"
} with RDBBaseException(message,cause) {

  def this(cause: Throwable) = this(Some(cause))
}
