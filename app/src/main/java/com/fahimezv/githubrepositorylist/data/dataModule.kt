package com.fahimezv.githubrepositorylist.data

import com.fahimezv.githubrepositorylist.data.network.generator.*
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module

val dataModule = module {
    //***************************************
    //               Network                *
    //***************************************

    // ------------- Generators -------------

    factory {
        if (BuildConfig.DEBUG) {    // development build
            HttpLoggingInterceptor.Level.BODY
        } else {    // production build
            HttpLoggingInterceptor.Level.BASIC
        }
    }

    single {
        val networkEnvironment: NetworkEnvironment = NetworkEnvironmentImpl()
        networkEnvironment
    }

    factory {
        val networkHeadersGenerator: NetworkHeadersGenerator = NetworkHeaderGeneratorImpl()
        networkHeadersGenerator
    }



    single {
        val networkServiceFactory: NetworkServiceFactory = NetworkServiceFactoryImpl(
            converterFactory = get(),
            logLevel = get(),
            environment = get(),
            networkHeadersGenerator = get()
        )
        networkServiceFactory
    }

    factory {
        NetworkEnvironmentImpl()
    }

}