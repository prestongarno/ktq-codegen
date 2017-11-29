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

/**For organizing the utility objects/classes which provide stubs for schema types
 */
package com.prestongarno.ktq.hooks

import com.prestongarno.ktq.QInterface
import com.prestongarno.ktq.QModel
import com.prestongarno.ktq.QType

internal interface ModelProvider {
  val value: QModel<*>
}

/**
 * TODO -> Add type arguments for this and [Fragment] so no type casting on resolving interface fragment types
 */
internal interface FragmentContext/*<I> where I : QType, I : QInterface*/ {
  val fragments : Set<Fragment>
}

data class Fragment(val initializer: () -> QModel<QType>) {
  internal val model by lazy(initializer)

  override fun toString(): String {
    return "... on ${model.graphqlType}${model.toGraphql()}"
  }
}

