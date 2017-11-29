/*
 * Copyright (C) 2017 Preston Garno
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.prestongarno.ktq.adapters

import com.beust.klaxon.JsonObject
import com.prestongarno.ktq.ArgBuilder
import com.prestongarno.ktq.stubs.InterfaceListStub
import com.prestongarno.ktq.QInterface
import com.prestongarno.ktq.QModel
import com.prestongarno.ktq.QType
import com.prestongarno.ktq.hooks.Fragment
import com.prestongarno.ktq.hooks.FragmentContext
import com.prestongarno.ktq.properties.GraphQlProperty
import kotlin.reflect.KProperty

/**
 * Factory method for an Interface List GraphQL field delegate provider
 * @param I the type of interface
 * @param A the type of [ArgBuilder] */
fun <I, A> newInterfaceListStub(
    qproperty: GraphQlProperty, argBuilder: A?
): InterfaceListStub<I, A>
    where I : QType, I : QInterface, A : ArgBuilder =
    InterfaceListStubImpl(qproperty, argBuilder)

private data class InterfaceListStubImpl<I, out A>(
    private val qproperty: GraphQlProperty,
    private val argBuilder: A?
) : InterfaceListStub<I, A>
    where I : QType,
          I : QInterface,
          A : ArgBuilder {

  private val fragments = mutableSetOf<Fragment>()

  override fun provideDelegate(inst: QModel<*>, property: KProperty<*>): QField<List<QModel<I>>> =
      InterfaceListField<I>(qproperty, fragments, argBuilder.toMap()).bind(inst)

  override fun <T : I> on(initializer: () -> QModel<T>) {
    fragments += Fragment(initializer)
  }

  override fun config(argumentScope: A.() -> Unit) {
    argBuilder?.argumentScope()
  }
}

private data class InterfaceListField<out I>(
    override val qproperty: GraphQlProperty,
    override val fragments: Set<Fragment>,
    override val args: Map<String, Any>
) : QField<List<QModel<I>>>,
    FragmentContext,
    Adapter
    where I : QType,
          I : QInterface {

  private var value = emptyList<QModel<I>>()

  override fun accept(result: Any?): Boolean {
    return if (result is Collection<*>) {
      result.filterIsInstance<JsonObject>()
          .mapNotNull {
            it["__typename"]?.let { resultType ->
              fragments.find {
                it.model.graphqlType == resultType
              }
            }?.to(it)
          }.let {
        value = it.mapNotNull { (gen, json) ->
          @Suppress("UNCHECKED_CAST")
          gen.initializer().apply {
            accept(json)
          } as? QModel<I>
        }
      }
      return true
    } else false
  }

  override fun toRawPayload(): String {
    return qproperty.graphqlName + (if (args.isEmpty()) "" else args.entries.joinToString(
        prefix = "(", postfix = ")") { (key, value) ->
      "$key: " + formatAs(value)
    }) +
        fragments.joinToString(prefix = "{__typename,", postfix = "}") {
          "... on " + it.model.graphqlType + it.model.toGraphql()
        }
  }

  override fun getValue(inst: QModel<*>, property: KProperty<*>): List<QModel<I>> = value
}
