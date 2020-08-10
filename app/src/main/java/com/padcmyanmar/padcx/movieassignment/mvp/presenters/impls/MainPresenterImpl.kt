package com.padcmyanmar.padcx.movieassignment.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.movieassignment.data.model.MoviesModel
import com.padcmyanmar.padcx.movieassignment.data.model.impls.MoviesModelImpl
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.MainPresenter
import com.padcmyanmar.padcx.movieassignment.mvp.views.MainView
import com.padcmyanmar.padcx.shared.mvp.presenters.AbstractBasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    var mMoviesModel: MoviesModel = MoviesModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        loadDataFromAPI()

        getTopRatedMovies(lifecycleOwner)
        getPopularMovies(lifecycleOwner)
        getShowCasesMovies(lifecycleOwner)
        getGenres(lifecycleOwner)
        getPopularActors(lifecycleOwner)
    }

    override fun onTapMovie(movieId: Int) {
        mView?.navigateToDetails(movieId)
    }

    override fun onTapVideo(movieId: Int) {
        mMoviesModel.getVideoById(movieId)
            .subscribe {
                it.data.map {
                    mView?.navigateToYoutube(it.key)
                }
            }
    }

    private fun getShowCasesMovies(lifecycleOwner: LifecycleOwner) {
        mMoviesModel.getShowcaseMovies()
            .observe(lifecycleOwner, Observer {
                mView?.displayShowcasesMoviesList(it)
        })
    }

    private fun getTopRatedMovies(lifecycleOwner: LifecycleOwner) {
        mMoviesModel.getTopRatedMovies()
            .observe(lifecycleOwner, Observer {
                mView?.displayTopRatedMoviesList(it)
            })
    }

    private fun getPopularMovies(lifecycleOwner: LifecycleOwner) {
        mMoviesModel.getPopularMovies()
            .observe(lifecycleOwner, Observer {
                mView?.displayPopularMoviesList(it)
            })
    }

    private fun getGenres(lifecycleOwner: LifecycleOwner) {
        mMoviesModel.getGenreList()
            .observe(lifecycleOwner, Observer {
                mView?.displayGenresList(it)
            })
    }

    private fun getPopularActors(lifecycleOwner: LifecycleOwner) {
        mMoviesModel.getPopularActors()
            .observe(lifecycleOwner, Observer {
                mView?.displayPopularActorsList(it)
            })
    }

    private fun loadDataFromAPI() {
        mMoviesModel.getTopRatedMoviesAndSaveToDb( {},{} )
        mMoviesModel.getPopularMoviesAndSaveToDb( {}, {} )
        mMoviesModel.getShowcaseMoviesListAndSaveToDb( {},{})
        mMoviesModel.getGenresListAndSaveToDb({},{})
        mMoviesModel.getPopularActorsAndSaveToDb({},{})
    }
}