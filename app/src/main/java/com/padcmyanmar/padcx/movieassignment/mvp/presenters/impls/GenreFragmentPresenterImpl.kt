package com.padcmyanmar.padcx.movieassignment.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Transformations.map
import com.padcmyanmar.padcx.movieassignment.data.model.impls.MoviesModelImpl
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.AbstractBasePresenter
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.GenreFragmentPresenter
import com.padcmyanmar.padcx.movieassignment.mvp.views.GenreFragmentView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/4/2020.
 */
class GenreFragmentPresenterImpl : GenreFragmentPresenter, AbstractBasePresenter<GenreFragmentView>() {

    private var mMoviesModel = MoviesModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner, genresId: Int) {
        mMoviesModel.getMoviesListByGenreId(genresId)
            .map { it.data?.toList() ?: listOf()}
            .subscribe {
                mView?.displayGenreFragment(it)
            }
    }

    override fun onTapMovie(movieId: Int) {
        mView?.navigateToMovieDetail(movieId)
    }
}