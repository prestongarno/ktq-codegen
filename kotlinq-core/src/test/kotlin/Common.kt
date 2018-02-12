
infix fun Any?.matchesNotNull(other: Any?) = require(this!! == other!!) {
  "<'$this'> was not equal to <'$other'>"
}

infix fun Any.eq(other: Any?) = require(this == other) {
  "<'$this'> was not equal to <'$other'>"
}

fun Any?.println() = println(this)