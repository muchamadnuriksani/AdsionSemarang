package com.nbs.adsionsemarang.domain.detail

import com.nbs.adsionsemarang.BuildConfig
import com.nbs.adsionsemarang.data.lib.ApiClient
import com.nbs.adsionsemarang.data.lib.ApiService
import com.nbs.adsionsemarang.data.lib.OkHttpClientFactory
import com.nbs.adsionsemarang.data.lib.getParameterInterceptor
import com.nbs.adsionsemarang.data.model.MovieItem
import com.nbs.adsionsemarang.presentation.main.model.Movie
import com.nbs.adsionsemarang.mapper.getMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMovieInteractor: DetailMovieUseCase {

    lateinit var onDetailMovieListener: OnDetailMovieListener

    private val apiRequest = ApiService
        .createService(ApiClient::class.java,
            OkHttpClientFactory
                .create(arrayOf(getParameterInterceptor()),
                true),
            BuildConfig.BASE_URL)

    override fun getDetail(id: String) {
        apiRequest.getDetailMovie(id)
            .enqueue(object : Callback<MovieItem>{
                override fun onFailure(call: Call<MovieItem>, t: Throwable) {
                    onDetailMovieListener.onDetailMovieFailed("Gagal")
                }

                override fun onResponse(call: Call<MovieItem>, response: Response<MovieItem>) {
                    if (response.isSuccessful){
                        response.body()?.let {
                            onDetailMovieListener
                                .onDetailMovieSuccess(getMovie(it))
                        }
                    }
                }

            })
    }

    interface OnDetailMovieListener{
        fun onDetailMovieSuccess(movie: Movie)

        fun onDetailMovieFailed(message: String)
    }
}