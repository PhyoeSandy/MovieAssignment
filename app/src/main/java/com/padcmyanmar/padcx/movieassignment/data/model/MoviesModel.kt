package com.padcmyanmar.padcx.movieassignment.data.model

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.movieassignment.data.vos.GenresVO
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.data.vos.UserVO
import com.padcmyanmar.padcx.movieassignment.netowork.responses.ActorsAndCreatorsListResponse
import com.padcmyanmar.padcx.movieassignment.netowork.responses.MoviesListResponse
import com.padcmyanmar.padcx.movieassignment.netowork.responses.VideoListResponse
import io.reactivex.Observable

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
interface MoviesModel {

    fun getTopRatedMoviesAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getPopularMoviesAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getGenresListAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getShowcaseMoviesListAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getMovieDetailsAndSaveToDb(movieId: Int, onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getPopularActorsAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getActorsAndCreatorsById(movieId: Int) : Observable<ActorsAndCreatorsListResponse>

    fun getVideoById(movieId: Int) : Observable<VideoListResponse>

    fun getMoviesListByGenreId(genreId: Int) : Observable<MoviesListResponse>

    fun getTopRatedMovies() : LiveData<List<MovieVO>>

    fun getPopularMovies() : LiveData<List<MovieVO>>

    fun getShowcaseMovies() : LiveData<List<MovieVO>>

    fun getGenreList() : LiveData<List<GenresVO>>

    fun getMovieDetails(movieId: Int) : LiveData<MovieVO>

    fun getPopularActors() : LiveData<List<UserVO>>

}