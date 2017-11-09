package com.prestongarno.ktq.interfaceFragments

import com.google.common.truth.Truth.assertThat
import com.prestongarno.ktq.QInterfaceType
import com.prestongarno.ktq.QModel
import com.prestongarno.ktq.QSchemaType.*
import com.prestongarno.ktq.QType
import org.intellij.lang.annotations.Language
import org.junit.Test


object Object : QInterfaceType {
  val value by QScalar.intStub()
}

object Query : QType {
  val get by QInterfaces.stub<Object>()
}


class MyObject : QModel<Object>(Object) {
  val result by model.value.withDefault(100)
}

class TestFragmentsBasic {

  @Test fun `make sure fragment is possible`() {

    require(MyObject().result == 100)

    require(MyObject().apply {
      onResponse("{\"value\": 69}")
    }.result == 69)

    val query = object : QModel<Query>(Query) {

      val field by model.get {

        on { MyObject() }

        config {
          addArg("Hello", "World")
        }
      }

    }
    assertThat(query.toGraphql(false)).isEqualTo("""
      {get(\"Hello\": \"World\"){__typename,... on Object{value}}}
    """.trimIndent())

    @Language("JSON") val response = """
      {
        "get": [
          {
            "__typename": "Object",
            "value": "Hello, World!"
          }
        ]
      }
      """

    require(query.onResponse(response))
  }

}
