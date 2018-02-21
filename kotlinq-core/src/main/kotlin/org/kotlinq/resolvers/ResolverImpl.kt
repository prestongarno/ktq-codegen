package org.kotlinq.resolvers

import org.kotlinq.api.Adapter
import org.kotlinq.api.DeserializingAdapter
import org.kotlinq.api.Fragment
import org.kotlinq.api.FragmentAdapter
import org.kotlinq.api.InstanceAdapter
import org.kotlinq.api.ParsingAdapter
import org.kotlinq.api.Resolver
import java.io.InputStream
import java.util.LinkedList

internal
class ResolverImpl : Resolver {

  override fun resolve(value: Map<String, Any?>, target: Fragment): Boolean =
      InstanceResolver(target, value).resolveFromRoot()

  override fun visit(target: InstanceAdapter) = Unit

  override fun visit(target: FragmentAdapter) = Unit

  override fun visit(target: ParsingAdapter) = Unit

  override fun visit(target: DeserializingAdapter) = Unit

  /**
   * Stack-based resolver algorithm
   */
  private
  class InstanceResolver(private val definition: Fragment, private val values: Map<String, Any?>) : Resolver {

    val stack = LinkedList<Map<String, Any?>>()

    fun push(values: Map<String, Any?>) = stack.addFirst(values)
    fun pop() {
      stack.removeFirst()
    }

    fun resolveFromRoot(): Boolean = resolve(values, definition)

    override fun resolve(value: Map<String, Any?>, target: Fragment): Boolean {
      push(value)
      target.graphQlInstance.accept(this)
      pop()
      return target.graphQlInstance.isResolved()
    }

    override fun visit(target: InstanceAdapter) {
      stack.peek().jsonObjectNamed(target)?.let {
        push(it)
        // TODO add Transformer<T> interface for not only list properties, but also so that
        // visitors can have control over setting values & verifying result
        target.setValue(it, this)
        pop()
      }
    }

    override fun visit(target: FragmentAdapter) {

      stack.peek().jsonObjectNamed(target)?.let { values ->
        push(values)
        values["__typename"]?.toString()?.let { target.setValue(it, values, this) }
        pop()
      }
    }

    override fun visit(target: ParsingAdapter) {
      target.setValue(stack.peek()[target.propertyInfo.graphQlName]?.toString())
    }

    override fun visit(target: DeserializingAdapter) {
      (stack.peek()[target.propertyInfo.graphQlName]?.let {
        it as? InputStream ?: it.toString().byteInputStream()
      } ?: "".byteInputStream()).let(target::setValue)
    }
  }

}

@Suppress("UNCHECKED_CAST")
fun Map<String, Any?>.jsonObjectNamed(adapter: Adapter): Map<String, Any>? {
  return this[adapter.propertyInfo.graphQlName] as? Map<String, Any>
}

