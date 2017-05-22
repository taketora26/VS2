package model.character

import model.ddd.Identifier

/**
  * キャラクターの識別子
  */
case class CharacterId(value: Int) extends Identifier[Int]