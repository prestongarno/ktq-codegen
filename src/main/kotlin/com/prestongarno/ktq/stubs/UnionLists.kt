package com.prestongarno.ktq.stubs

import com.prestongarno.ktq.ArgBuilder
import com.prestongarno.ktq.DelegateProvider
import com.prestongarno.ktq.QModel
import com.prestongarno.ktq.QUnionType
import com.prestongarno.ktq.SchemaStub
import com.prestongarno.ktq.adapters.newUnionListStub
import com.prestongarno.ktq.properties.GraphQlProperty

interface UnionListStub<out T : QUnionType, out A : ArgBuilder> : DelegateProvider<List<QModel<*>>> {

  fun config(scope: A.() -> Unit)

  fun fragment(scope: T.() -> Unit)

  companion object {

    @PublishedApi internal fun <T : QUnionType> noArgStub(
        qproperty: GraphQlProperty,
        unionObject: T
    ): UnionListStub.Query<T> =
        QueryImpl(qproperty, unionObject)

    @PublishedApi internal fun <T : QUnionType, A : ArgBuilder> optionalArgStub(
        qproperty: GraphQlProperty,
        unionObject: T
    ): UnionListStub.OptionalConfigQuery<T, A> =
        OptionalConfigQueryImpl(qproperty, unionObject)

    @PublishedApi internal fun <T : QUnionType, A : ArgBuilder> argStub(
        qproperty: GraphQlProperty,
        unionObject: T
    ): UnionListStub.ConfigurableQuery<T, A> =
        ConfigurableQueryImpl(qproperty, unionObject)

  }

  interface Query<out T : QUnionType> : SchemaStub {
    operator fun invoke(
        arguments: ArgBuilder? = null,
        scope: UnionListStub<T, ArgBuilder>.() -> Unit
    ): UnionListStub<T, ArgBuilder>

  }

  interface OptionalConfigQuery<out T : QUnionType, A : ArgBuilder> : ConfigurableQuery<T, A> {

    operator fun invoke(
        scope: UnionListStub<T, ArgBuilder>.() -> Unit
    ): UnionListStub<T, ArgBuilder>

  }

  interface ConfigurableQuery<out T : QUnionType, A : ArgBuilder> : SchemaStub {

    operator fun invoke(
        arguments: A,
        scope: UnionListStub<T, A>.() -> Unit
    ): UnionListStub<T, A>

  }

  private class QueryImpl<out T : QUnionType>(
      val qproperty: GraphQlProperty,
      val union: T
  ) : Query<T> {

    override fun invoke(arguments: ArgBuilder?, scope: UnionListStub<T, ArgBuilder>.() -> Unit) =
        newUnionListStub(qproperty, union, arguments ?: ArgBuilder()).apply(scope)

  }

  private class OptionalConfigQueryImpl<out T : QUnionType, A : ArgBuilder>(
      val qproperty: GraphQlProperty,
      val union: T
  ) : OptionalConfigQuery<T, A> {

    override fun invoke(scope: UnionListStub<T, ArgBuilder>.() -> Unit) =
        newUnionListStub(qproperty, union, ArgBuilder()).apply(scope)

    override fun invoke(arguments: A, scope: UnionListStub<T, A>.() -> Unit) =
        newUnionListStub(qproperty, union, arguments).apply(scope)

  }

  private class ConfigurableQueryImpl<out T : QUnionType, A : ArgBuilder>(
      val qproperty: GraphQlProperty,
      val union: T
  ) : ConfigurableQuery<T, A> {

    override fun invoke(arguments: A, scope: UnionListStub<T, A>.() -> Unit) =
        newUnionListStub(qproperty, union, arguments).apply(scope)

  }

}

