package com.prestongarno.ktq.stubs

import com.prestongarno.ktq.ArgBuilder
import com.prestongarno.ktq.QModel
import com.prestongarno.ktq.adapters.bind
import com.prestongarno.ktq.adapters.toMap
import com.prestongarno.ktq.properties.GraphQlProperty
import kotlin.reflect.KProperty

interface StringArrayDelegate<out A : ArgBuilder> : ScalarArrayDelegate<StringArrayStub> {

  var default: Array<String>?

  fun config(scope: A.() -> Unit)

  interface Query {
    operator fun invoke(
        arguments: ArgBuilder? = null,
        scope: (StringArrayDelegate<ArgBuilder>.() -> Unit)? = null
    ): StringArrayDelegate<ArgBuilder>

    operator fun provideDelegate(
        inst: QModel<*>,
        property: KProperty<*>
    ): StringArrayStub = invoke().provideDelegate(inst, property)
  }

  interface OptionalConfig<A : ArgBuilder> {

    operator fun invoke(
        arguments: A,
        scope: (StringArrayDelegate<A>.() -> Unit)?
    ): StringArrayDelegate<A>

    operator fun provideDelegate(
        inst: QModel<*>,
        property: KProperty<*>
    ): StringArrayStub

  }

  interface ConfigurableQuery<A : ArgBuilder> {

    operator fun invoke(
        arguments: A,
        scope: (StringArrayDelegate<A>.() -> Unit)? = null
    ): StringArrayDelegate<A>
  }
}

private class StringArrayDelegateImpl<out A : ArgBuilder>(
    private val qproperty: GraphQlProperty,
    private val argBuilder: A?
) : StringArrayDelegate<A>  {

  override var default: Array<String>? = null

  override fun provideDelegate(inst: QModel<*>, property: KProperty<*>): StringArrayStub =
      StringArrayStub(qproperty, default, argBuilder.toMap()).bind(inst)

  override fun config(scope: A.() -> Unit) { argBuilder?.scope() }
}

