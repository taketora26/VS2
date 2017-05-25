package util.ddd.lifecycle

import util.ddd.model.{Identifier => IdBase, Entity => EntityBase}

trait Repository[Identifier <: IdBase[_], Entity <: EntityBase[_]]