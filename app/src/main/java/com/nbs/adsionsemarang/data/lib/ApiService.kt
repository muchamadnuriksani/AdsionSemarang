package com.nbs.adsionsemarang.data.lib

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ghiyatshanif on 2/23/17.
 * purpose : generate retrofit service class
 */

object ApiService {

    fun <S> createService(serviceClass: Class<S>, okhttpClient: OkHttpClient, baseURl: String): S {

        val gson = GsonBuilder()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(baseURl)
                .client(okhttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        return retrofit.create(serviceClass)
    }
}
