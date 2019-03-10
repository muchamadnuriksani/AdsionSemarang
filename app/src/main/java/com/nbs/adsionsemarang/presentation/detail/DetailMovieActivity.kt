package com.nbs.adsionsemarang.presentation.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.nbs.adsionsemarang.R
import com.nbs.adsionsemarang.presentation.main.model.Movie
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity(),
    DetailMovieContract.View{

    private val presenter = DetailMoviePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        supportActionBar?.let {
            it.apply {
                title = "Detail Movie"
                setDisplayHomeAsUpEnabled(true)
            }
        }

        val id = intent.getStringExtra("id")
        presenter.getDetailMovie(id)
    }

    override fun showDetailMovie(movie: Movie) {
        with(movie){
            Glide.with(this@DetailMovieActivity)
                .load(poster)
                .into(imgMovie)

            val content = "$title \n\n $overview \n $url"
            tvContent.text = content
        }
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT)
            .show()
    }
}
