package com.devnunu.sample.common

import android.app.Application
import com.airbnb.mvrx.Mavericks
import com.devnunu.sample.di.dtoModule
import com.devnunu.sample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this@SampleApplication)
        startKoin {
            androidContext(this@SampleApplication)
            modules(
                dtoModule,
                viewModelModule
            )
        }
    }
}