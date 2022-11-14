package com.fahimezv.githubrepositorylist.data.network.generator

import com.fahimezv.githubrepositorylist.data.network.generator.model.NetworkRequestHeader

class NetworkHeaderGeneratorImpl : NetworkHeadersGenerator {
    override fun getHeaders(requestContentLength: Long?): List<NetworkRequestHeader> {
        // Have been Used the array list  because if need to add another header we can add easily
        val arrayList = ArrayList<NetworkRequestHeader>()
        arrayList.addAll(
            listOf(
                NetworkRequestHeader("application", "vnd.github.v3+json")
            )
        )

        return arrayList

    }
}