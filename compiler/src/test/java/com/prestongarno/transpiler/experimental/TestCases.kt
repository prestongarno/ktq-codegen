package com.prestongarno.transpiler.experimental

import com.prestongarno.ktq.runtime.set
import org.junit.Test

class TestCases {
	@Test
	fun testQueryAndGet() {

		val testMap = mapOf<String, Any>(
				Pair("codeCount", 1000000),
				Pair("issueCount", 3535353),
				Pair("edges", listOf(SubFragment())),
				Pair("nodes", listOf(SubSearchItem())),
				Pair("pageInfo", CustomPageInfo()))

		val result = FragmentedQuery()
		set(result, testMap)
		assert(result.codeCount == 1000000)
		assert(result.issueCount == 3535353)
		assert(result.edges.size == 1)
		assert(result.nodes.size == 1)
	}

	@Test
	fun tetsPayloadInputArgsQuery() {
		val testMap = mapOf(Pair("nodes", listOf(SubSearchItem())))

		val result = FragmentedQuery()
		set(result, testMap)
		assert(result.nodes.size == 1)
	}
}

