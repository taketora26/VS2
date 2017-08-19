package application.controllers

import domain.lifecycle.chracter.CharacterRepository
import play.api.mvc.Controller

class testController(
                      characterRepository: CharacterRepository
                    ) extends Controller {

 val x = characterRepository.resolveAll()

  print(x)

}
