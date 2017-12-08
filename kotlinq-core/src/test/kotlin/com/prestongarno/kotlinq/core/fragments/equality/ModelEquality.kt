package com.prestongarno.kotlinq.core.fragments.equality

import com.google.common.truth.Truth.assertThat
import com.prestongarno.kotlinq.core.ArgBuilder
import com.prestongarno.kotlinq.core.QEnumType
import com.prestongarno.kotlinq.core.QInterface
import com.prestongarno.kotlinq.core.QModel
import com.prestongarno.kotlinq.core.QSchemaType.QEnum
import com.prestongarno.kotlinq.core.QSchemaType.QInterfaces
import com.prestongarno.kotlinq.core.QSchemaType.QScalar
import com.prestongarno.kotlinq.core.QSchemaType.QTypes
import com.prestongarno.kotlinq.core.QSchemaType.QUnion
import com.prestongarno.kotlinq.core.QType
import com.prestongarno.kotlinq.core.QUnionType
import com.prestongarno.kotlinq.core.adapters.Adapter
import com.prestongarno.kotlinq.core.internal.extractedPayload
import com.prestongarno.kotlinq.core.primitives.eq
import com.prestongarno.kotlinq.core.primitives.neq
import com.prestongarno.kotlinq.core.stubs.FloatDelegate
import com.prestongarno.kotlinq.core.stubs.FloatStub
import com.prestongarno.kotlinq.core.stubs.InterfaceListStub
import com.prestongarno.kotlinq.core.stubs.StringDelegate
import com.prestongarno.kotlinq.core.stubs.StringStub
import com.prestongarno.kotlinq.core.stubs.UnionStub
import com.prestongarno.kotlinq.core.type.BasicTypeList.PersonModel
import com.prestongarno.kotlinq.core.type.Person
import com.prestongarno.kotlinq.core.type.TypeStubQueryable.*
import org.junit.Test

/*********************************************************
 *  Manually-created schema definition
 *********************************************************/

object Entity : QUnionType by QUnionType.new() {

  fun onPerson(init: () -> QModel<Person>) = on(init)

  fun onOrganization(init: () -> QModel<Organization>) = on(init)

}

interface Vehicle : QInterface, QType {

  val model: StringDelegate.Query

  val owner: UnionStub.Query<Entity>

  val maxSpeed: FloatDelegate.Query

}

object Airplane : Vehicle {

  override val model by QScalar.String.stub()

  override val maxSpeed by QScalar.Float.stub()

  val engineHours by QScalar.Float.stub()

  val maxPassengers by QScalar.Int.stub()

  override val owner by QUnion.stub(Entity)
}

object Car : Vehicle {

  override val model by QScalar.String.stub()

  override val maxSpeed by QScalar.Float.stub()

  val mileage by QScalar.Float.stub()

  val maxPassengers by QScalar.Int.stub()

  override val owner by QUnion.stub(Entity)

}

object Organization : QType {

  val name by QScalar.String.stub()

  val type by QEnum.stub<OrganizationType>()

  val members by QTypes.stub<Person>()
}

enum class OrganizationType : QEnumType {
  CORPORATION,
  NON_PROFIT
}

object EqualityQuery : QType {
  val search by QInterfaces.List.configStub<Vehicle, EqualityQuery.SearchArgs>()

  class SearchArgs(keyword: String) : ArgBuilder() {

    val keyword by arguments.notNull("keyword", keyword)

  }
}

/*********************************************************
 *  Models from schema definition
 *********************************************************/

class EqualityImpl(
    keyword: String,
    fragment: InterfaceListStub<Vehicle, EqualityQuery.SearchArgs>.() -> Unit
) : QModel<EqualityQuery>(EqualityQuery) {

  val searchResult by model.search(EqualityQuery.SearchArgs(keyword), fragment)
}


open class AirplaneFrag0 : QModel<Airplane>(Airplane) {
  val modelName by model.model

  val maxSpeed by model.maxSpeed
}

open class AirplaneFrag1 : QModel<Airplane>(Airplane) {
  val modelName by model.model
}

open class AirplaneFrag2(spread: Entity.() -> Unit) : AirplaneFrag1() {
  val owner by model.owner { fragment(spread) }
}

open class MPersonModel : PersonModel() {
  val address by model.address.query(::DefaultAddress)
}

open class OrganizationModel : QModel<Organization>(Organization) {
  val name by model.name
  val members by model.members.query(::PersonModel)
  val type by model.type
}

/*********************************************************
 *  Class with test cases
 *********************************************************/

class ModelEquality {

  @Test fun simpleModelInEqualityCheck() {

    assertThat(AirplaneFrag0())
        .isNotEqualTo(AirplaneFrag1())
  }

  @Test fun delegatesPropertyEquality() {

    val f = AirplaneFrag0().getDelegate<StringStub>("model")

    val g = AirplaneFrag1().getDelegate<StringStub>("model")

    f eq g

    f.hashCode() eq g.hashCode()

    val h = AirplaneFrag0().getDelegate<FloatStub>("maxSpeed")

    val i = AirplaneFrag0().getDelegate<FloatStub>("maxSpeed")

    h.qproperty.hashCode() eq i.qproperty.hashCode()
    h eq i

    h.hashCode() eq i.hashCode()

    val j = AirplaneFrag2({ onPerson(::PersonModel) }).getDelegate<Adapter>("owner")

    class AirplaneFragLocal : AirplaneFrag2({ onPerson(::PersonModel) }) {
      val smthingElse by model.maxPassengers
    }

    j eq AirplaneFragLocal().getDelegate("owner")

    AirplaneFrag2({ onPerson(::PersonModel) }) neq AirplaneFragLocal()
  }

  @Test fun simpleModelEqualityCheck() {

    AirplaneFrag0() eq AirplaneFrag0()

    AirplaneFrag1() eq AirplaneFrag1()

    val ctor = { AirplaneFrag2({ onPerson(::PersonModel) }) }

    ctor() eq ctor()

    ctor().hashCode() eq ctor().hashCode()
  }

  @Test fun toGraphQL() {

    extractedPayload(MPersonModel()).assertBracketsMatch()

    val query = EqualityImpl("ZR1") {
      on {
        AirplaneFrag2 {
          onPerson(::MPersonModel)
          onOrganization(::OrganizationModel)
        }
      }
    }

    extractedPayload(query).apply {
      assertThat(this)
          .isEqualTo("{search(keyword: \\\"ZR1\\\"){... on Airplane{owner{... on Organization{type," +
              "members{age,name},name}... on Person{address{line1},age,name}},model}}}")
      this.assertBracketsMatch()
    }
  }
}

@Suppress("UNCHECKED_CAST") private fun <Z : Adapter> QModel<*>.getDelegate(named: String): Z =
    fields[named] as? Z ?: throw IllegalArgumentException("Field $named is not of that type!")

private fun Any?.println() = println(this)

private fun String.assertBracketsMatch() =
    count { it == '{' } eq count { it == '}' }