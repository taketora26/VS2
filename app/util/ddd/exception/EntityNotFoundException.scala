package util.ddd.exception

class EntityNotFoundException(message: String, cause: Option[Throwable] = None)
extends BaseException(message,cause.orNull) {

  def this(message: String, cause: Throwable) = this(message,Some(cause))
}
