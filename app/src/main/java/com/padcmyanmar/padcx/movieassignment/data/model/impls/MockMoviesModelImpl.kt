package com.padcmyanmar.padcx.movieassignment.data.model.impls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.padcmyanmar.padcx.movieassignment.data.dummy.*
import com.padcmyanmar.padcx.movieassignment.data.model.MoviesModel
import com.padcmyanmar.padcx.movieassignment.data.vos.GenresVO
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.data.vos.UserVO
import com.padcmyanmar.padcx.movieassignment.netowork.responses.ActorsAndCreatorsListResponse
import com.padcmyanmar.padcx.movieassignment.netowork.responses.MoviesListResponse
import com.padcmyanmar.padcx.movieassignment.netowork.responses.VideoListResponse
import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/5/2020.
 */
object MockMoviesModelImpl : MoviesModel {
    override fun getTopRatedMoviesAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {}

    override fun getPopularMoviesAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {}

    override fun getGenresListAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {}

    override fun getShowcaseMoviesListAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {}

    override fun getMovieDetailsAndSaveToDb(movieId: Int, onSuccess: () -> Unit, onError: (String) -> Unit) {}

    override fun getPopularActorsAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {}

    override fun getActorsAndCreatorsById(movieId: Int): Observable<ActorsAndCreatorsListResponse> {
        return getDummyActorsAndCreators().toObservable().map { ActorsAndCreatorsListResponse() }
    }

    override fun getVideoById(movieId: Int): Observable<VideoListResponse> {
        return getDummyVideos().toObservable().map { VideoListResponse() }
    }

    override fun getMoviesListByGenreId(genreId: String): Observable<MoviesListResponse> {
        return getDummyMovies().toObservable().map { MoviesListResponse() }
    }

    override fun getTopRatedMovies(): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovies())
        return liveData
    }

    override fun getPopularMovies(): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovies())
        return liveData
    }

    override fun getShowcaseMovies(): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovies())
        return liveData
    }

    override fun getGenreList(): LiveData<List<GenresVO>> {
        val liveData = MutableLiveData<List<GenresVO>>()
        liveData.postValue(getDummnyGenres())
        return liveData
    }

    override fun getMovieDetails(movieId: Int): LiveData<MovieVO> {
        val liveData = MutableLiveData<MovieVO>()
        liveData.postValue(getDummyMovies().first {
            it.id == movieId
        })
        return liveData
    }

    override fun getPopularActors(): LiveData<List<UserVO>> {
        val liveData = MutableLiveData<List<UserVO>>()
        liveData.postValue(getDummyActors())
        return liveData
    }
}