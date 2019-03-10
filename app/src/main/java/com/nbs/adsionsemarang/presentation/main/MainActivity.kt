package com.nbs.adsionsemarang.presentation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.nbs.adsionsemarang.BuildConfig
import com.nbs.adsionsemarang.R
import com.nbs.adsionsemarang.data.lib.ApiClient
import com.nbs.adsionsemarang.data.lib.ApiService
import com.nbs.adsionsemarang.data.lib.OkHttpClientFactory
import com.nbs.adsionsemarang.data.lib.getParameterInterceptor
import com.nbs.adsionsemarang.presentation.main.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainContract.View {

    private val presenter: MainPresenter by inject{ parametersOf( this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getMovie()
    }

    override fun showMovie(list: List<Movie>) {
        var movieTitle: String? = ""
        for (movie in list){
            Log.d("Movie", movie.title)

            with(movie){
                movieTitle += "$title\n"
            }
        }

        tvMovieTitle.text = movieTitle?.trim()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
