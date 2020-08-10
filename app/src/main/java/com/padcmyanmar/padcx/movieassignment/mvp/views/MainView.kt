package com.padcmyanmar.padcx.movieassignment.mvp.views

import com.padcmyanmar.padcx.movieassignment.data.vos.GenresVO
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.data.vos.UserVO
import com.padcmyanmar.padcx.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
interface MainView : BaseView {
    fun displayTopRatedMoviesList(movies: List<MovieVO>)
    fun displayPopularMoviesList(movies: List<MovieVO>)
    fun displayShowcasesMoviesList(movies: List<MovieVO>)
    fun displayGenresList(genres: List<GenresVO>)
    fun displayPopularActorsList(actors: List<UserVO>)
    fun navigateToDetails(movieId: Int)
    fun navigateToYoutube(videoKey: String)
}