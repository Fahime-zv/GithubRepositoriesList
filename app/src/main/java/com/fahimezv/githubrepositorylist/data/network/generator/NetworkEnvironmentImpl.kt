package com.fahimezv.githubrepositorylist.data.network.generator

class NetworkEnvironmentImpl: NetworkEnvironment {
    override val baseUrl: String
        get() = K.baseUrl
}
