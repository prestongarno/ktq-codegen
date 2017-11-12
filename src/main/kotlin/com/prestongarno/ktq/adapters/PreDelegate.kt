package com.prestongarno.ktq.adapters

import com.prestongarno.ktq.ArgBuilder
import com.prestongarno.ktq.properties.GraphQlProperty

/**
 * Base class for all objects who produce immutable field delegates
 */
internal abstract class PreDelegate(val qproperty: GraphQlProperty)

