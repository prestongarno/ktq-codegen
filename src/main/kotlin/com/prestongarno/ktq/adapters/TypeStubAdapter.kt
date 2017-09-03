package com.prestongarno.ktq.adapters

import com.prestongarno.ktq.*
import com.prestongarno.ktq.internal.ModelProvider
import kotlin.reflect.KProperty

internal class TypeStubAdapter<I : QSchemaType, P : QModel<I>, out B : TypeArgBuilder>(
    fieldName: String, val builderInit: (TypeArgBuilder) -> B
) : FieldAdapter(fieldName),
    TypeStub<P, I>,
    InitStub<I>,
    QTypeConfigStub<I, B>,
    TypeArgBuilder,
    ModelProvider {

  lateinit var result: P

  override fun config(): B = builderInit(TypeStubAdapter<I, P, B>(fieldName, builderInit))

  override fun getModel(): QModel<*> = result

  override fun getValue(inst: QModel<*>, property: KProperty<*>): P = this.result

  override fun <R : QModel<*>> provideDelegate(inst: R, property: KProperty<*>): TypeStub<P, I> {
    this.property = property
    return apply { super.onProvideDelegate(inst) }
  }

  @Suppress("UNCHECKED_CAST") override fun <U : QModel<I>> init(of: () -> U): TypeStub<U, I>
      = apply { result = of() as P } as TypeStub<U, I>

  @Suppress("UNCHECKED_CAST") override fun <U : QModel<T>, T : QSchemaType> build(init: () -> U): TypeStub<U, T>
      = apply { result = init() as P } as TypeStub<U, T>

  override fun addArg(name: String, value: Any): TypeArgBuilder = apply { args.put(name, value) }

}