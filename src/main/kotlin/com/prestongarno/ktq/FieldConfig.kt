package com.prestongarno.ktq

import kotlin.reflect.KProperty

internal abstract class FieldConfig(val graphqlProperty: QProperty) : Payload {

  /**
   * A map of arguments for the field (for graphql) */
  val args by lazy { mutableMapOf<String, Any>() }

  /**
   * The actual graphqlName for the delegation set value. does not have to be the same name and/or the same return type
   */
  lateinit var targetProperty: KProperty<*>

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as FieldConfig

    if (graphqlProperty != other.graphqlProperty) return false

    return true
  }

  override fun hashCode(): Int {
    return graphqlProperty.hashCode()
  }

}

internal fun formatAs(value: Any): String {
  return when (value) {
    is Int, is Boolean, Float -> "$value"
    is String -> "\\\"$value\\\""
    is QInput -> value.toPayloadString()
    is Enum<*> -> value.name
    is List<*> -> value
        .map { formatAs(it ?: "") }
        .filter { it.isNotBlank() }
        .joinToString(",", "[ ", " ]")
    else -> throw UnsupportedOperationException("Unsupported type: $value")
  }
}
