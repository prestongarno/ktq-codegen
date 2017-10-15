package com.prestongarno.ktq.adapters


import com.prestongarno.ktq.ArgBuilder
import com.prestongarno.ktq.FieldConfig
import com.prestongarno.ktq.NullableStub
import com.prestongarno.ktq.QProperty
import com.prestongarno.ktq.QConfigStub
import com.prestongarno.ktq.QModel
import com.prestongarno.ktq.Stub
import kotlin.reflect.KProperty

/**
 * Adapter for scalar fields */
/*internal class NullableStubAdapter<T, out B: ArgBuilder>(
    property: QProperty,
    val builderInit: (ArgBuilder) -> B
) : FieldConfig(property),
    NullableStub<T>,
    QConfigStub<T, B>,
    ArgBuilder {

  override fun accept(result: Any?): Boolean = TODO("not implemented")

  val value : T? = null

  override fun config(): B = builderInit(NullableStubAdapter<T, B>(graphqlProperty, builderInit))

  override fun <R : QModel<*>> provideDelegate(inst: R, property: KProperty<*>): NullableStub<T> {
    return apply { super.onDelegate(inst, property) }
  }

  override fun getValue(inst: QModel<*>, property: KProperty<*>): T? = value

  @Suppress("UNCHECKED_CAST") override fun <T> build() : Stub<T> = this as Stub<T>

  override fun addArg(name: String, value: Any): ArgBuilder = apply { args.put(name, value)  }

}*/
