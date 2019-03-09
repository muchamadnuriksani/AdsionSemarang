package com.nbs.adsionsemarang.data.lib

import com.nbs.adsionsemarang.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("discover/movie?sort_by=popularity.desc")
    fun getListPopularMovie(): Call<MovieResponse>
}