package com.prestongarno.ktq

import com.beust.klaxon.JsonObject
import com.prestongarno.ktq.adapters.Adapter
import com.prestongarno.ktq.internal.FragmentGenerator
import kotlin.reflect.KProperty

interface UnionInitStub<out T : QSchemaUnion> : SchemaStub {
  fun fragment(what: T.() -> Unit): UnionStub
}

internal open class UnionAdapter<I : QSchemaUnion>(
    override val graphqlProperty: QProperty,
    objectModel: I
) : QModel<I>(objectModel),
    Adapter,
    UnionInitStub<I>,
    UnionStub,
    QSchemaUnion {

  val fragments = mutableSetOf<FragmentGenerator>()

  /**
   * Recurse to the base model of the graph */
  override val queue by lazy { model.queue }

  var dispatcher: (I.() -> Unit)? = null

  override val args: Map<String, Any> by lazy { mapOf<String, Any>() }

  internal var value: QModel<*>? = null

  override fun accept(result: Any?): Boolean {
    return if (result is JsonObject) {
      value = result["__typename"]?.let { resultType ->
        fragments.find { it.model.graphqlType == resultType }?.model
      }
      resolved = value != null
      return value?.accept(result) == true
    } else false
  }

  override fun fragment(what: I.() -> Unit): UnionStub {
    dispatcher = what
    return this
  }

  override fun toRawPayload(): String = fragments.joinToString(prefix = "__typename,") {
    "... on ${it.model.graphqlType}${it.model.fields
        .joinToString(",", "{", "]") {
          "${it.graphqlProperty.graphqlType}'${it.graphqlProperty.graphqlName}'"
        }}"
  }

  override fun getValue(
      inst: QModel<*>,
      property: KProperty<*>
  ): QModel<QSchemaType> {
    return value ?: throw IllegalStateException("null")
  }

  override fun onDelegate(inst: QModel<*>, property: KProperty<*>) {
    inst.fields.add(this)
  }

  override fun <R : QModel<*>> provideDelegate(inst: R, property: KProperty<*>): UnionStub {

    val next = UnionAdapter(QProperty.from(
        property,
        this.graphqlProperty.graphqlType,
        false,
        this.graphqlProperty.graphqlName
    ), model)

    synchronized(queue) {
      queue.put(next)
      dispatcher?.invoke(model)
      queue.pop()
    }
    next.onDelegate(inst, property)
    return next
  }

  override fun on(init: () -> QModel<*>) {
    fragments += FragmentGenerator(init)
  }
}

internal class BaseUnionAdapter<I : QSchemaUnion>(model: I) : UnionAdapter<I>(QProperty.ROOT, model) {
  override val queue: DispatchQueue by lazy { DispatchQueue() }

  override fun on(init: () -> QModel<*>) {
    queue.get()?.on(init)
  }
}