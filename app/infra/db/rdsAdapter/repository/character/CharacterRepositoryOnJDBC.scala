package infra.db.rdsAdapter.repository.character

import domain.lifecycle.chracter.CharacterRepository
import domain.model.chracter.{Character, CharacterId, Name, PictureURL}
import infra.db.rdsAdapter.dao.character.{CharacterSkillDAO, CharactersDAO, RoleDAO, SkillDAO}
import infra.db.rdsAdapter.model.character.CharactersRecord
import infra.db.rdsAdapter.repository.IOContextExecutorOnJDBC
import util.ddd.exception.EntityNotFoundException
import util.ddd.lifecycle.IOContext

import scala.util.Try

class CharacterRepositoryOnJDBC(
                                 charactersDao: CharactersDAO,
                                 roleDao: RoleDAO,
                                 skillDAO: SkillDAO,
                                 characterSkillDAO: CharacterSkillDAO,
                                 iOContextExecutorOnJDBC: IOContextExecutorOnJDBC = IOContextExecutorOnJDBC
                               ) extends CharacterRepository {

  def resolveAll()(implicit ctx: IOContext): Try[Seq[Character]] =
    iOContextExecutorOnJDBC.execute { implicit session =>
      charactersDao.findAll() match {
        case records if records.nonEmpty =>
          records.map(convertToEntity)
        case Nil =>
          throw new EntityNotFoundException(s"table=${charactersDao.tableName}")
      }
    }

  private[rdsAdapter] def convertToEntity(record: CharactersRecord): Character =
    Character(
      identifier = CharacterId(record.id),
      nickName = Name(record.name),
        fullName = Name(record.fullName),
        realName = Name(record.realName),
        role = None,
        skill = None,
      // TODO これこんな感じでいいのか？
        pictureURL = Option(PictureURL(record.imageUrl.getOrElse("")))
    )

}
