package com.nbs.adsionsemarang.presentation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.nbs.adsionsemarang.BuildConfig
import com.nbs.adsionsemarang.R
import com.nbs.adsionsemarang.data.lib.ApiClient
import com.nbs.adsionsemarang.data.lib.ApiService
import com.nbs.adsionsemarang.data.lib.OkHttpClientFactory
import com.nbs.adsionsemarang.data.lib.getParameterInterceptor
import com.nbs.adsionsemarang.presentation.main.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        presenter.getMovie()
    }

    override fun showMovie(list: List<Movie>) {
        for (movie in list){
            Log.d("Movie", movie.title)
        }
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
