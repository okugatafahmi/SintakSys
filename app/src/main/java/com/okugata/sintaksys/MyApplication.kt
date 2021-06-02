package com.okugata.sintaksys

import android.app.Application
import com.okugata.sintaksys.di.useCaseModule
import com.okugata.sintaksys.di.viewModelModule
import com.okugata.sintaksys.core.di.networkModule
import com.okugata.sintaksys.core.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}