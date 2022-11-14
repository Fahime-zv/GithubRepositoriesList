package com.fahimezv.githubrepositorylist

import android.app.Application
import com.fahimezv.githubrepositorylist.core.coreModule
import com.fahimezv.githubrepositorylist.data.dataModule
import com.fahimezv.githubrepositorylist.presentation.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        // Setup Koin
        startKoin {
            androidLogger(Level.ERROR) // Koin Android Logger
            androidContext(this@App) // Inject Android context
            modules(dataModule, coreModule, presentationModule) // Modules
        }
    }
}