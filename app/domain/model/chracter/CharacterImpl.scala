package domain.model.chracter


case class CharacterImpl (
  identifier:CharacterId,
  nickName: Name,
  fullName: Name,
  realName: Name,
  role: Option[Seq[Role]],
  skill:Option[Seq[Skill]],
  pictureURL:Option[PictureURL]
                         ) extends Character{

}
