package util.ddd.exception

class BaseException(message:String, cause: Option[Throwable] = None)
extends Exception(message,cause.orNull){

  def this(message: String,cause: Throwable) = this(message,Some(cause))
}
