package com.prestongarno.ktq.unions.experimental

import com.beust.klaxon.JsonObject
import com.prestongarno.ktq.InitStub
import com.prestongarno.ktq.QModel
import com.prestongarno.ktq.QModel.Companion.NONE
import com.prestongarno.ktq.QSchemaType
import com.prestongarno.ktq.QSchemaType.*
import com.prestongarno.ktq.QSchemaUnion
import com.prestongarno.ktq.Stub
import com.prestongarno.ktq.UnionStubImpl
import org.junit.Test
import kotlin.test.assertTrue

/**================================================================*/
/**  Example                                                       */
/**================================================================*/

class MyUserModel : QModel<User>(User) {
  val name by model.name
}

object Actor : QSchemaUnion by QSchemaUnion.create(Actor) {
  fun user(init: Actor.() -> QModel<User>) = fragment<Actor> { init() }
  fun bot(init: Actor.() -> QModel<Bot>) = fragment<Actor> { init() }
}

class MyBotModel : QModel<Bot>(Bot) {
  val foobar = Bot.owner.on {
    user { MyUserModel() }
    bot { MyBotModel() }
  }
  val bar by lazy { (foobar as UnionStubImpl<Actor>).value }

}


object Bot : QSchemaType {
  val name: Stub<String> by QScalar.stub()

  val owner by QUnion.stub(Actor)
}

object User : QSchemaType {
  val name: Stub<String> by QScalar.stub()
}

object Query : QSchemaType {
  val me: InitStub<Actor> by QType.stub()
}

class ExperimentalUnionModel {

  @Test fun testModelStructure() {
    val botModel = MyBotModel()

    //val botModel2 = MyBotModel()

    val input = JsonObject(mapOf(
        Pair("__typename", "User"),
        Pair("name", "Preston")
    ))
    val input2 = JsonObject(mapOf(
        Pair("__typename", "User"),
        Pair("name", "Garno")
    ))

    require(botModel.foobar is UnionStubImpl<*>)

    require((botModel.foobar as UnionStubImpl<*>).accept(input))

    require(botModel.bar is MyUserModel)

    assertTrue(botModel.accept(input))
    assertTrue(botModel.foobar.accept(input))
    assertTrue(botModel.foobar != NONE)

    assertTrue((botModel.bar as MyUserModel).name == "Preston")

    assertTrue((MyBotModel().apply { (foobar as UnionStubImpl<*>).accept(input2) }.bar as MyUserModel).name == "Garno")

    println(botModel.bar)
    println(Actor.user { MyUserModel() }.toGraphql(false))
    println(MyUserModel().toGraphql(false))
    assertTrue(botModel.bar !== MyBotModel().bar)

  }
}
