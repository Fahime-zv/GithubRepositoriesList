package com.fahimezv.githubrepositorylist.core

import com.fahimezv.githubrepositorylist.core.util.ModelUtils
import com.google.gson.GsonBuilder
import org.koin.dsl.module

val coreModule = module {
    //****************************************
    //                  Utils                *
    //****************************************
    factory {
        GsonBuilder()
    }

    factory {
        ModelUtils(builder = get())
    }
}