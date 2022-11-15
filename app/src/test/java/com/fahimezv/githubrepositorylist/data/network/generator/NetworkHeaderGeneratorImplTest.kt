package com.fahimezv.githubrepositorylist.data.network.generator

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class NetworkHeaderGeneratorTest
{
    private lateinit var networkHeadersGenerator: NetworkHeaderGeneratorImpl
    @Before
    fun setUp() {

        networkHeadersGenerator = NetworkHeaderGeneratorImpl()
    }

    @Test
    fun `getHeaders must not contains duplicates`() {
        val list = networkHeadersGenerator.getHeaders(null)
        val actual = list.stream().map { item -> item.key }.distinct().count()
        val expected = list.stream().count()
        assertEquals(expected, actual)
    }

    @Test
    fun `getHeaders must contains application`() {
        val list = networkHeadersGenerator.getHeaders(null)
        assertTrue(list.stream().anyMatch { item ->
            item.key == "application" && item.value == "vnd.github.v3+json"
        })
    }

}