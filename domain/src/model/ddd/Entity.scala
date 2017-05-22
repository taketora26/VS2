package model.ddd

/**
  * エンティティを表すトレイトの型
  * @tparam ID 識別子
  */
trait Entity[ID <: Identifier[_]] {

  /**
    * エンティティの識別子。
    */
  val identifier:ID

  /**
    * ハッシュコードを返す。
    * @return ハッシュコード
    */
  override final def hashCode:Int = 31 * identifier.##

  /**
    * 指定されたオブジェクトと等価であるかを判定する。
    *
    * @param that オブジェクト
    * @return 　等価である場合はtrue
    */
  override final def equals(that:Any): Boolean = that match {
    case that: Entity[_] => identifier == that.identifier
    case _ => false
  }

}
