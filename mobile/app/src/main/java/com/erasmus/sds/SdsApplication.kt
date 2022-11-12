package com.erasmus.sds

import android.app.Application
import com.erasmus.sds.di.networkModule
import com.erasmus.sds.di.repositoryModule
import com.erasmus.sds.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SdsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SdsApplication)
            modules(
                networkModule, repositoryModule, viewModelModule
            )
        }
    }
}