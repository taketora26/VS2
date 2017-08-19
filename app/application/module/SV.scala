package application.module

import com.google.inject.AbstractModule
import domain.lifecycle.chracter.CharacterRepository
import infra.db.rdsAdapter.IOContextManagerOnJDBC
import infra.db.rdsAdapter.repository.character.CharacterRepositoryOnJDBC
import util.ddd.lifecycle.IOContextManager

object SV extends AbstractModule {

 // val characterRepository: CharacterRepository = new CharacterRepositoryOnJDBC

  override def configure(): Unit = {
    bind(classOf[IOContextManager])
      .to(classOf[IOContextManagerOnJDBC])
    bind(classOf[CharacterRepository])
    .to(classOf[CharacterRepositoryOnJDBC])
  }
}
