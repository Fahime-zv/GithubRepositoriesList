package com.fahimezv.githubrepositorylist.data.network.generator

import com.fahimezv.githubrepositorylist.data.network.generator.model.NetworkRequestHeader


interface NetworkHeadersGenerator {
    fun getHeaders(requestContentLength: Long?): List<NetworkRequestHeader>
}