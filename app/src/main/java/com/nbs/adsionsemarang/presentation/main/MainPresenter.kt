package com.nbs.adsionsemarang.presentation.main

import android.util.Log
import com.nbs.adsionsemarang.domain.main.MainInteractor
import com.nbs.adsionsemarang.presentation.main.model.Movie

class MainPresenter(private val view: MainContract.View): MainContract.Presenter,
    MainInteractor.OnMovieListener{

    val mainInteractor = MainInteractor()

    init {
        mainInteractor.listener = this
    }

    override fun getMovie() {
        view.showHideProgressBar(true)
        mainInteractor.getRemoteMovie()
    }

    override fun onMovieSuccess(list: List<Movie>?) {
        view.showHideProgressBar(false)
        list?.let {
            view.showMovie(it)
        }
    }

    override fun onMovieFailed(message: String) {
        view.showHideProgressBar(false)
        Log.d("Test", message)
        view.showError(message)
    }
}