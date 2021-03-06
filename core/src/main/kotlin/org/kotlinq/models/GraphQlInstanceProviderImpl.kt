package org.kotlinq.models

import org.kotlinq.api.Adapter
import org.kotlinq.api.BindableContext
import org.kotlinq.api.Fragment
import org.kotlinq.api.GraphQlInstanceProvider
import org.kotlinq.common.addLast

internal
class GraphQlInstanceProviderImpl : GraphQlInstanceProvider {

  override fun newContextBuilder(): BindableContext {
    val properties = mutableListOf<Adapter>()
    return BindableContext.newBindableContext(properties::addLast) {
      Fragment.createFragment(it, GraphQlInstanceImpl(properties))
    }
  }

}