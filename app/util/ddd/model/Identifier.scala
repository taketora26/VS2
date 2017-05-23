package util.ddd.model

/**
  * エンティティの識別子を表すトレイト
  * エンティティで用いられる識別子を型として表現することを目的としている。
  * @tparam A 識別子の値を表す型
  *
  * Created by taketoikeda on 2017/05/22.
  */
trait Identifier[+A] extends Serializable {

  /**
    * 識別子の値を取得する。
    * @return 識別子の値
    *
    */
  def value: A

}

/**
  * 識別子の値が空だった場合の例外。
  */

case class EmptyIdentifierException() extends Exception

/**
  * 空の識別子を表す値のオブジェクト
  */

class EmptyIdentifier extends Identifier[Nothing] {
  def value:Nothing = throw EmptyIdentifierException()

  override def equals(obj:Any): Boolean = obj match {
    case that: EmptyIdentifier => this eq that
    case _ => false
  }

  override def hashCode(): Int = 31 * 1

  override def toString: String = "EmptyIdentifier"
}

object EmptyIdentifier extends EmptyIdentifier

private[model] class IdentifierImpl[A](val value: A)
extends Identifier[A]{

  override def equals(obj: Any): Boolean = obj match {
    case that: EmptyIdentifier => false
    case that: Identifier[_] =>
      value == this.value
    case _ => false
  }

  override def hashCode:Int = 31 * value.##

  override def toString: String = s"Identifier($value)"

}

/**
  * コンパニオンオブジェクト
  */
object Identifier {

  /**
    * `Identifier`を生成する。
    *
    * @param value 識別子の値
    * @tparam A 識別子の値の型
    * @return `Identifier`
    */
  def apply[A](value:A): Identifier[A] = new IdentifierImpl(value)

  /**
    * 空の`Identifier`
    * @return`Identifier`
    */
  def empty[A]: Identifier[A] = EmptyIdentifier

  /**
    * 抽出子メソッド。
    * @param v `Identifier`
    * @tparam A 識別子の値の型
    * @return 識別子の値
    */
  def unapply[A](v: Identifier[A]):Option[A] = Some(v.value)

}
