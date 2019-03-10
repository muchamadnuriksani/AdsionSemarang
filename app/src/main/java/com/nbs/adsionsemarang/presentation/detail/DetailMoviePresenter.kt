package com.nbs.adsionsemarang.presentation.detail

import com.nbs.adsionsemarang.domain.detail.DetailMovieInteractor
import com.nbs.adsionsemarang.presentation.main.model.Movie

class DetailMoviePresenter(private val view: DetailMovieContract.View):
    DetailMovieContract.Presenter,
    DetailMovieInteractor.OnDetailMovieListener{

    private val detailMovieInteractor =
        DetailMovieInteractor()

    init {
        detailMovieInteractor.onDetailMovieListener = this
    }

    override fun getDetailMovie(id: String) {
        detailMovieInteractor.getDetail(id)
    }

    override fun onDetailMovieSuccess(movie: Movie) {
        view.showDetailMovie(movie)
    }

    override fun onDetailMovieFailed(message: String) {
        view.showError(message)
    }
}