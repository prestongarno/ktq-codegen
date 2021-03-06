package org.kotlinq.jvm

import org.kotlinq.api.Adapter
import org.kotlinq.api.Fragment
import org.kotlinq.api.Kind
import kotlin.reflect.KClass


internal
class ClassFragmentResolver<out T : Data?>(
    private val map: Map<String, Any?>,
    private val fragment: ClassFragment<T>
) {

  val isValid: Boolean by lazy { Validation.canResolve(map, fragment) }

  fun resolve(): T? =
      if (!isValid) null else fragment.init(map.toResult(fragment))
}


// TODO extract to interface here for configuration
internal
object Validation {

  fun canResolve(map: Map<String, Any?>, fragment: ClassFragment<*>): Boolean =
      fragment.graphQlInstance.properties.entries.all {
        isValidValue(it.value.propertyInfo.kind, map[it.key])
      }

  private operator fun Fragment.get(property: String): Adapter? =
      graphQlInstance.properties[property]


  fun isValidValue(kind: Kind, value: Any?): Boolean {

    value ?: return kind is Kind.NullableKind

    // can't call Kind#isScalar since that counts "List<Int>" as a scalar
    if (value.isScalar()) return kind is Kind.Scalar
        && value.scalarKind()?.isTypeCompatible(kind) == true

    if (kind is Kind.ListKind)
      return (value as? List<*>)?.all { isValidValue(kind.wrapped, it) } ?: false

    // best we can do here, without reflection on the back end
    return (kind as? Kind.NullableKind)
        ?.wrapped
        ?.let { isValidValue(it, value) }
        ?: value.asStringMap() != null
  }


  private
  fun Any.isScalar() = scalarKind() != null

  private fun Any?.scalarKind() = when (this) {
    is Boolean -> Kind.bool
    is Int -> Kind.integer
    is String -> Kind.string
    is Float -> Kind.float
    else -> null
  }


  private fun String.getFrom(map: Map<String, Any?>): Any? = map[this]

}

@Suppress("UNCHECKED_CAST")
internal
fun Any?.asStringMap(): Map<String, Any?>? =
    if ((this as? Map<*, *>)?.entries?.all { it.key is String } == true) this as? Map<String, Any?> else null

@Suppress("UNCHECKED_CAST")
internal inline fun <reified T : Any> Any?.asList(): List<T>? =
    if ((this as? List<*>)?.none { !T::class.isInstance(it) } == true) this as List<T> else null

@Suppress("UNCHECKED_CAST")
internal fun <T> Any?.asList(clazz: KClass<*>): List<T>? {
  return if ((this as? List<*>)?.none { !clazz.isInstance(it) } == true) this as List<T> else null
}
