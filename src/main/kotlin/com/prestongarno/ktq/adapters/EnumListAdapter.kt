package com.prestongarno.ktq.adapters

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.prestongarno.ktq.ArgBuilder
import com.prestongarno.ktq.QEnumType
import com.prestongarno.ktq.QModel
import com.prestongarno.ktq.properties.GraphQlProperty
import com.prestongarno.ktq.stubs.EnumListStub
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

@PublishedApi internal fun <T, A> newEnumListDelegate(
    qproperty: GraphQlProperty,
    arguments: A?,
    enumClass: KClass<T>
): EnumListStub<T, A> where T : Enum<*>, T : QEnumType, A : ArgBuilder =
    EnumListStubImpl(qproperty, arguments, enumClass)

@PublishedApi internal fun <T> newEnumListField(
    qproperty: GraphQlProperty,
    enumClass: KClass<T>
): QField<List<T>> where T : Enum<*>, T : QEnumType =
    EnumListAdapterImpl(qproperty, emptyMap(), enumClass)

private data class EnumListStubImpl<T, out A>(
    val qproperty: GraphQlProperty,
    val arguments: A? = null,
    val enumClass: KClass<T>
) : EnumListStub<T, A>
    where T : Enum<*>,
          T : QEnumType,
          A : ArgBuilder {

  override var default: T? = null

  override fun config(scope: A.() -> Unit) {
    arguments?.scope()
  }

  override fun provideDelegate(
      inst: QModel<*>,
      property: KProperty<*>
  ): QField<List<T>> =
      EnumListAdapterImpl<T>(qproperty, arguments.toMap(), enumClass).bind(inst)

}

private data class EnumListAdapterImpl<T>(
    override val qproperty: GraphQlProperty,
    override val args: Map<String, Any>,
    val enumClass: KClass<T>
) : QField<List<T>>, Adapter
    where T : Enum<*>,
          T : QEnumType {

  private val value = mutableListOf<T>()

  override fun toRawPayload(): String = qproperty.graphqlName +
      if (args.isEmpty()) "" else args.entries.joinToString(
          prefix = "(", postfix = ")", separator = ","
      ) { "${it.key}: ${formatAs(it)}" }

  override fun accept(result: Any?): Boolean {
    if (result is JsonArray<*>)
      result.filterIsInstance<String>().mapNotNull { str ->
        enumClass.java.enumConstants.find {
          it.name == str
        }
      }.let { transformed ->
        value.addAll(transformed)
      }
    return result is JsonArray<*>
  }

  override fun getValue(inst: QModel<*>, property: KProperty<*>): List<T> = value

}
