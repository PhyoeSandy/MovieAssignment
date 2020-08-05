package com.padcmyanmar.padcx.movieassignment.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.movieassignment.data.model.MoviesModel
import com.padcmyanmar.padcx.movieassignment.data.model.impls.MoviesModelImpl
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.DetailsPresenter
import com.padcmyanmar.padcx.movieassignment.mvp.views.DetailsView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class DetailsPresenterImpl : DetailsPresenter, AbstractBasePresenter<DetailsView>() {

    var mMovieModel: MoviesModel = MoviesModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner, movieId: Int) {
        loadDataFromAPI(movieId)
        getDetails(lifecycleOwner,movieId)
        getActorsAndCreatorsList(lifecycleOwner,movieId)
    }

    private fun getActorsAndCreatorsList(lifecycleOwner: LifecycleOwner, movieId: Int) {
        mMovieModel.getActorsAndCreatorsById(movieId)
            .subscribe {
                mView?.displayActorsList(it.actors)
                mView?.displayCreatorsList(it.creators)
            }
    }

    private fun getDetails(lifecycleOwner: LifecycleOwner, movieId: Int) {
        mMovieModel.getMovieDetails(movieId)
            .observe(lifecycleOwner, Observer {
                mView?.displayDetailsData(it)
            })
    }

    private fun loadDataFromAPI(movieId: Int) {
        mMovieModel.getMovieDetailsAndSaveToDb(movieId, {}, {})
    }
}