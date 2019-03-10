package com.nbs.adsionsemarang.presentation.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.nbs.adsionsemarang.R
import com.nbs.adsionsemarang.presentation.detail.DetailMovieActivity
import com.nbs.adsionsemarang.presentation.main.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), MainContract.View,
    MovieAdapter.OnMovieItemCallback{

    private lateinit var presenter: MainPresenter

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovie.layoutManager = GridLayoutManager(this,
            2)
        rvMovie.setHasFixedSize(true)
        adapter = MovieAdapter(ArrayList(), this)
        rvMovie.adapter = adapter

        presenter = MainPresenter(this)
        presenter.getMovie()
    }

    override fun showMovie(list: List<Movie>) {
        for (movie in list){
            Log.d("Movie", movie.title)
        }

        adapter.movieItems.addAll(list)
        adapter.notifyDataSetChanged()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showHideProgressBar(isShown: Boolean) {
        if (isShown)
            progressBar.visibility = View.VISIBLE
        else
            progressBar.visibility = View.GONE
    }

    override fun onMovieItemClicked(movie: Movie) {
        val intent = Intent(this,
            DetailMovieActivity::class.java)
        intent.putExtra("id", movie.id)
        startActivity(intent)

    }
}
