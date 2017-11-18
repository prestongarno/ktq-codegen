package com.prestongarno.ktq.stubs

import com.prestongarno.ktq.ArgBuilder
import com.prestongarno.ktq.DelegateProvider
import com.prestongarno.ktq.QModel
import com.prestongarno.ktq.QUnionType
import com.prestongarno.ktq.SchemaStub
import com.prestongarno.ktq.adapters.newUnionField
import com.prestongarno.ktq.properties.GraphQlProperty

interface UnionStub<out T : QUnionType, out A : ArgBuilder> : DelegateProvider<QModel<*>?> {

  fun config(scope: A.() -> Unit)

  fun fragment(scope: T.() -> Unit)

  companion object {

    @PublishedApi internal fun <T : QUnionType> noArgStub(
        qproperty: GraphQlProperty,
        unionObject: T
    ): UnionStub.Query<T> = QueryImpl(qproperty, unionObject)

    @PublishedApi internal fun <T : QUnionType, A : ArgBuilder> optionalArgStub(
        qproperty: GraphQlProperty,
        unionObject: T
    ): UnionStub.OptionalConfigQuery<T, A> = OptionalConfigQueryImpl(qproperty, unionObject)

    @PublishedApi internal fun <T : QUnionType, A : ArgBuilder> argStub(
        qproperty: GraphQlProperty,
        unionObject: T
    ): UnionStub.ConfigurableQuery<T, A> = ConfigurableQueryImpl(qproperty, unionObject)
  }

  interface Query<out T : QUnionType> : SchemaStub {

    operator fun invoke(
        arguments: ArgBuilder? = null,
        scope: UnionStub<T, ArgBuilder>.() -> Unit
    ): UnionStub<T, ArgBuilder>

  }

  interface OptionalConfigQuery<out T : QUnionType, A : ArgBuilder> : ConfigurableQuery<T, A> {

    operator fun invoke(
        scope: UnionStub<T, ArgBuilder>.() -> Unit
    ): UnionStub<T, ArgBuilder>

  }

  interface ConfigurableQuery<out T : QUnionType, A : ArgBuilder> : SchemaStub {

    operator fun invoke(
        arguments: A,
        scope: UnionStub<T, A>.() -> Unit
    ): UnionStub<T, ArgBuilder>

  }

  private class QueryImpl<out T : QUnionType>(
      val qproperty: GraphQlProperty,
      val unionObject: T
  ) : Query<T> {

    override fun invoke(
        arguments: ArgBuilder?,
        scope: UnionStub<T, ArgBuilder>.() -> Unit
    ): UnionStub<T, ArgBuilder> =
        newUnionField(qproperty, unionObject, arguments ?: ArgBuilder()).apply(scope)

  }

  private class OptionalConfigQueryImpl<out T : QUnionType, A : ArgBuilder>(
      val qproperty: GraphQlProperty,
      val unionObject: T
  ) : OptionalConfigQuery<T, A> {

    override fun invoke(arguments: A, scope: UnionStub<T, A>.() -> Unit) =
        newUnionField(qproperty, unionObject, arguments).apply(scope)

    override fun invoke(scope: UnionStub<T, ArgBuilder>.() -> Unit) =
        newUnionField(qproperty, unionObject, ArgBuilder()).apply(scope)

  }

  private class ConfigurableQueryImpl<out T : QUnionType, A : ArgBuilder>(
      val qproperty: GraphQlProperty,
      val unionObject: T
  ) : ConfigurableQuery<T, A> {

    override fun invoke(arguments: A, scope: UnionStub<T, A>.() -> Unit): UnionStub<T, ArgBuilder> =
        newUnionField(qproperty, unionObject, arguments).apply(scope)

  }

}