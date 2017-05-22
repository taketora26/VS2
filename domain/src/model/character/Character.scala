package model.character

import model.ddd.{Entity, Identifier}

/**
  * キャラクターのモデル
  */
trait Character extends Entity[CharacterId]{

  /** キャラクターの識別子 */
  override val identifier: CharacterId

  /** ニックネーム */
  val nickName: Name

  /** フルネーム */
  val fullName: Name

  /** 本名 */
  val realName: Name

  /** 役割 */
  val role: Option[Seq[Role]]

  /** 技術 */
  val skill: Option[Seq[Skill]]

  /** 顔写真 */
  val pictureURL:Option[PictureURL]

//  /**　登録日 */
//  val createdAt: DateTime
//
//  /** 更新日時 */
//  val updatedAt: Option[DateTime]

}

object Character {
  def apply(
           identifier: CharacterId,
           nickName: Name,
           fullName: Name,
           realName: Name,
           role: Option[Seq[Role]],
           skill: Option[Seq[Skill]],
           pictureURL:Option[PictureURL]):Character =
  CharacterImpl(
    identifier,
      nickName,
      fullName,
      realName,
      role,
      skill,
      pictureURL
  )

}