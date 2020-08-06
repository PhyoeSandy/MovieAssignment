package com.padcmyanmar.padcx.movieassignment.data.model.impls

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.movieassignment.data.model.BaseModel
import com.padcmyanmar.padcx.movieassignment.data.model.MoviesModel
import com.padcmyanmar.padcx.movieassignment.data.vos.GenresVO
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.data.vos.UserVO
import com.padcmyanmar.padcx.movieassignment.netowork.responses.ActorsAndCreatorsListResponse
import com.padcmyanmar.padcx.movieassignment.netowork.responses.MoviesListResponse
import com.padcmyanmar.padcx.movieassignment.netowork.responses.VideoListResponse
import com.padcmyanmar.padcx.movieassignment.utils.EM_NO_INTERNET_CONNECTION
import com.padcmyanmar.padcx.movieassignment.utils.PARAM_API_VALUE
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
object MoviesModelImpl : MoviesModel, BaseModel() {
    override fun getTopRatedMoviesAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mMoviesApi.getTopRatedMoviesList(PARAM_API_VALUE)
            .map { it.data?.toList() ?: listOf()}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.forEach {
                    it.status = 0
                }
                mDB.moviesDao().insertAllMovies(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
        }

    override fun getPopularMoviesAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mMoviesApi.getPopularMoviesList(PARAM_API_VALUE)
            .map { it.data?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                it.forEach {
                    it.status = 1
                }
                mDB.moviesDao().insertAllMovies(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getGenresListAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mMoviesApi.getGenresList(PARAM_API_VALUE)
            .map { it.data ?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mDB.moviesDao().insertAllGenres(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getShowcaseMoviesListAndSaveToDb( onSuccess: () -> Unit, onError: (String) -> Unit) {
        mMoviesApi.getShowcasesMoviesList(PARAM_API_VALUE)
            .map { it.data ?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.forEach {
                    it.status = 2
                }
                mDB.moviesDao().insertAllMovies(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getMovieDetailsAndSaveToDb(movieId: Int, onSuccess: () -> Unit, onError: (String) -> Unit) {
        mMoviesApi.getMovieDetails(movieId, PARAM_API_VALUE)
            .map { it.data ?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mDB.moviesDao().insertAllMovies(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getPopularActorsAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mMoviesApi.getPopularActors(PARAM_API_VALUE)
            .map { it.data ?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.forEach {
                    it.status = 0
                }
                mDB.moviesDao().insertAllUsers(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getActorsAndCreatorsById(movieId: Int): Observable<ActorsAndCreatorsListResponse> {
        return mMoviesApi.getActorsAndCreditorsById(movieId, PARAM_API_VALUE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getVideoById(movieId: Int): Observable<VideoListResponse> {
        return mMoviesApi.getVideoKey(movieId, PARAM_API_VALUE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getMoviesListByGenreId(genreId: Int): Observable<MoviesListResponse> {
        return mMoviesApi.getMoviesListByGenre(PARAM_API_VALUE, genreId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getTopRatedMovies(): LiveData<List<MovieVO>> {
        return mDB.moviesDao().getTopRatedMoviesList()
    }

    override fun getPopularMovies(): LiveData<List<MovieVO>> {
        return mDB.moviesDao().getPopularMoviesList()
    }

    override fun getShowcaseMovies(): LiveData<List<MovieVO>> {
        return mDB.moviesDao().getShowcaseMoviesList()
    }

    override fun getGenreList(): LiveData<List<GenresVO>> {
        return mDB.moviesDao().getGenresList()
    }

    override fun getMovieDetails(movieId: Int) : LiveData<MovieVO> {
        return mDB.moviesDao().getMovieById(movieId)
    }

    override fun getPopularActors(): LiveData<List<UserVO>> {
        return mDB.moviesDao().getPopularActorsList()
    }

}
