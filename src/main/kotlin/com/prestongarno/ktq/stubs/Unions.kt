package com.prestongarno.ktq.stubs

import com.prestongarno.ktq.ArgBuilder
import com.prestongarno.ktq.QUnionType
import com.prestongarno.ktq.SchemaStub
import com.prestongarno.ktq.UnionStub

interface UnionFragment<out T : QUnionType> : SchemaStub {
  operator fun invoke(scope: T.() -> Unit): UnionStub
}

interface UnionConfigStub<out T : QUnionType, in A : ArgBuilder> : SchemaStub {
  operator fun invoke(arguments: A, scope: T.() -> Unit): UnionStub
}

interface UnionListInitStub<out T : QUnionType> : SchemaStub {
  fun fragment(what: T.() -> Unit): UnionListStub
}