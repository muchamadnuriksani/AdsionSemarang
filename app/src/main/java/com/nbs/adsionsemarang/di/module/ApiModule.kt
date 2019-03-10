package com.nbs.adsionsemarang.di.module

import com.nbs.adsionsemarang.BuildConfig
import com.nbs.adsionsemarang.data.lib.ApiClient
import com.nbs.adsionsemarang.data.lib.ApiService
import com.nbs.adsionsemarang.data.lib.OkHttpClientFactory
import com.nbs.adsionsemarang.data.lib.getParameterInterceptor
import org.koin.dsl.module.module

val apiModule = module {
    single { OkHttpClientFactory.create(interceptors = arrayOf(getParameterInterceptor()), showDebugLog = true) }

    single { ApiService.createService(ApiClient::class.java, get(), BuildConfig.BASE_URL) }
}