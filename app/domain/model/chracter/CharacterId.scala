package domain.model.chracter

import util.ddd.model.Identifier

/**
  * キャラクターの識別子
  */
case class CharacterId(value: Int) extends Identifier[Int]