package com.fahimezv.githubrepositorylist.data.network.generator

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter

class NetworkServiceFactoryImpl(
    private val converterFactory: Converter.Factory,
    logLevel: HttpLoggingInterceptor.Level,
    private val environment: NetworkEnvironment,
    private val networkHeadersGenerator: NetworkHeadersGenerator,
) : NetworkServiceFactory(converterFactory, logLevel, environment) {

    override fun interceptors(): List<NetworkInterceptor> {
        return arrayListOf(
            getNetworkRequestInterceptor()
        )
    }

    private fun getNetworkRequestInterceptor(): NetworkInterceptor {
        return NetworkRequestInterceptor(
            networkHeadersGenerator)
    }

}