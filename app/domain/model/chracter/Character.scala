package domain.model.chracter

import util.ddd.model.Entity

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

}

object Character {
  def apply(
           identifier: CharacterId,
           nickName: Name,
           fullName: Name,
           realName: Name,
           role: Option[Seq[Role]],
           skill: Option[Seq[Skill]],
           pictureURL:Option[PictureURL]
           ):Character =

  CharacterImpl(
    identifier = identifier,
      nickName = nickName,
      fullName = fullName,
      realName = realName,
      role = role,
      skill = skill,
      pictureURL = pictureURL
  )

}