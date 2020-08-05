package com.padcmyanmar.padcx.movieassignment.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.padcx.movieassignment.data.vos.UserVO
import com.padcmyanmar.padcx.movieassignment.data.vos.GenresVO
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovies(movies: List<MovieVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: MovieVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGenres(genres: List<GenresVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(actors: List<UserVO>)

    @Query("SELECT * FROM movie WHERE status = 0")
    fun getTopRatedMoviesList() : LiveData<List<MovieVO>>

    @Query("SELECT * FROM movie WHERE status = 1")
    fun getPopularMoviesList() : LiveData<List<MovieVO>>

    @Query("SELECT * FROM movie WHERE status = 2")
    fun getShowcaseMoviesList() : LiveData<List<MovieVO>>

    @Query("SELECT * FROM genres")
    fun getGenresList() : LiveData<List<GenresVO>>

    @Query("SELECT * FROM movie WHERE id=:movieId")
    fun getMovieById(movieId: Int) : LiveData<MovieVO>

    @Query("SELECT * FROM user")
    fun getPopularActorsList() : LiveData<List<UserVO>>

}