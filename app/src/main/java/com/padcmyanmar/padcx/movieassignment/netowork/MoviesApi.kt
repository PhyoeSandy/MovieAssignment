package com.padcmyanmar.padcx.movieassignment.netowork

import com.padcmyanmar.padcx.movieassignment.netowork.responses.*
import com.padcmyanmar.padcx.movieassignment.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
interface MoviesApi {
    @GET(TOP_RATED_MOVIE)
    fun getTopRatedMoviesList(@Query(PARAM_API_KEY) apiKey: String) : Observable<MoviesListResponse>

    @GET(POPULAR_MOVIE)
    fun getPopularMoviesList(@Query(PARAM_API_KEY) apiKey: String) : Observable<MoviesListResponse>

    @GET(NOW_PLAYING_MOVIE)
    fun getShowcasesMoviesList(@Query(PARAM_API_KEY) apiKey: String) : Observable<MoviesListResponse>

    @GET(GENERES)
    fun getGenresList(@Query(PARAM_API_KEY) apiKey : String) : Observable<GenreListResponse>

    @GET("$MOVIE_DETAIL/{MOVIE_ID}")
    fun getMovieDetails(@Path("MOVIE_ID") movieID: Int, @Query(PARAM_API_KEY) apiKey: String) : Observable<MoviesListResponse>

    @GET("$MOVIE_DETAIL/{MOVIE_ID}/videos")
    fun getVideoKey(@Path("MOVIE_ID") movieID: Int, @Query(PARAM_API_KEY) apiKey: String) : Observable<VideoListResponse>

    @GET(DISCOVER_MOVIE)
    fun getMoviesListByGenre(@Query(PARAM_API_KEY) apiKey: String, @Query(GENRE_KEY) key:Int) : Observable<MoviesListResponse>

    @GET("$MOVIE_DETAIL/{MOVIE_ID}/credits")
    fun getActorsAndCreditorsById(@Path("MOVIE_ID") movieID: Int, @Query(PARAM_API_KEY) apiKey: String) : Observable<ActorsAndCreatorsListResponse>

    @GET(POPULAR_ACTOR)
    fun getPopularActors(@Query(PARAM_API_KEY) apiKey : String) : Observable<ActorsListResponse>

}