package com.fahimezv.githubrepositorylist.data

import com.fahimezv.githubrepositorylist.data.network.generator.*
import com.fahimezv.githubrepositorylist.data.network.repository.RepoRepository
import com.fahimezv.githubrepositorylist.data.network.repository.UsersRepository
import com.fahimezv.githubrepositorylist.data.network.service.ServiceProvider
import com.fahimezv.githubrepositorylist.data.network.service.ServiceProviderImpl
import com.google.gson.GsonBuilder
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    //***************************************
    //               Network                *
    //***************************************

    // ------------- Generators -------------
    single {
        val gsonBuilder: GsonBuilder = get() // Defined in coreModule.kt
        val converterFactory: Converter.Factory = GsonConverterFactory.create(gsonBuilder.create())
        converterFactory
    }
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
        val serviceProvider: ServiceProvider = ServiceProviderImpl(
            serviceFactory = get()
        )
        serviceProvider
    }

    factory {
        NetworkEnvironmentImpl()
    }

    // ------------- Repositories -------------
    factory {
        UsersRepository(service = get<ServiceProvider>().getUsersService())
    }
    factory {
        RepoRepository(service = get<ServiceProvider>().getReposService())
    }


}