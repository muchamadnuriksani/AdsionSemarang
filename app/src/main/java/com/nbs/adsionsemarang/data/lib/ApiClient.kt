package com.nbs.adsionsemarang.data.lib

import com.nbs.adsionsemarang.data.model.MovieItem
import com.nbs.adsionsemarang.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("discover/movie?sort_by=popularity.desc")
    fun getListPopularMovie(): Call<MovieResponse>

    @GET("movie/{movie_id}")
    fun getDetailMovie(@Path("movie_id") id: String):
            Call<MovieItem>
}