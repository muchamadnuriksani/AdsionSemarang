package com.nbs.adsionsemarang.domain.main

import com.nbs.adsionsemarang.data.lib.ApiClient
import com.nbs.adsionsemarang.data.model.MovieResponse
import com.nbs.adsionsemarang.presentation.main.model.Movie
import com.nbs.adsionsemarang.presentation.main.model.getMovies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainInteractor(private val apiRequest: ApiClient): MainUseCase{

    var listener: OnMovieListener? = null

    override fun getRemoteMovie() {
        apiRequest.getListPopularMovie()
            .enqueue(object : Callback<MovieResponse>{
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    listener?.onMovieFailed("Gagal")
                }

                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    if (response.isSuccessful){
                       response.body()?.result.let {
                           listener?.onMovieSuccess(getMovies(it))
                       }
                    }
                }

            })
    }

    interface OnMovieListener{
        fun onMovieSuccess(list: List<Movie>?)

        fun onMovieFailed(message: String)
    }
}