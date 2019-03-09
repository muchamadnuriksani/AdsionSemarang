package com.nbs.adsionsemarang.data.lib

import com.nbs.adsionsemarang.BuildConfig
import okhttp3.Interceptor

fun getParameterInterceptor(): Interceptor {
    val params = HashMap<String, String>()
    params.put("api_key", BuildConfig.API_KEY)
    return ParameterInterceptor(params)
}