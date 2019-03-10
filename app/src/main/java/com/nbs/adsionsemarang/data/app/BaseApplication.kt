package com.nbs.adsionsemarang.data.app

import android.app.Application
import com.nbs.adsionsemarang.di.module.apiModule
import com.nbs.adsionsemarang.di.module.feature.mainModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module

class BaseApplication: Application() {

    val modules: List<Module> = listOf(
        apiModule,
        mainModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin(this, modules)
    }
}