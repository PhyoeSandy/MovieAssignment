package com.padcmyanmar.padcx.movieassignment.mvp.views

import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/4/2020.
 */
interface GenreFragmentView : BaseView {
    fun displayGenreFragment(movies: List<MovieVO>)
    fun navigateToMovieDetail(movieId: Int)
}