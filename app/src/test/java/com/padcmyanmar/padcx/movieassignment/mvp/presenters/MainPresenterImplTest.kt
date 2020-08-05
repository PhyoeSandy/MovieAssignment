package com.padcmyanmar.padcx.movieassignment.mvp.presenters

import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.movieassignment.data.dummy.getDummnyGenres
import com.padcmyanmar.padcx.movieassignment.data.dummy.getDummyActors
import com.padcmyanmar.padcx.movieassignment.data.dummy.getDummyMovies
import com.padcmyanmar.padcx.movieassignment.data.dummy.getDummyVideos
import com.padcmyanmar.padcx.movieassignment.data.model.MoviesModel
import com.padcmyanmar.padcx.movieassignment.data.model.impls.MockMoviesModelImpl
import com.padcmyanmar.padcx.movieassignment.data.model.impls.MoviesModelImpl
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.data.vos.VideoVO
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.impls.MainPresenterImpl
import com.padcmyanmar.padcx.movieassignment.mvp.views.MainView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/5/2020.
 */
@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {

    private lateinit var mPresenter: MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView

    private lateinit var mMovieModel: MoviesModel

    @Before
    fun setupPresenter() {
        MockKAnnotations.init(this)

        MoviesModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMovieModel = MockMoviesModelImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMoviesModel = this.mMovieModel
    }

    @Test
    fun onTapMovie_callNavigateToMovieDetails() {
        val movie = MovieVO()
        movie.id = 1

        mPresenter.onTapMovie(movie.id)
        verify {
            mView.navigateToDetails(movie.id)
        }
    }

    @Test
    fun onTapVideo_callNavigateToYoutube() {
        val movie = MovieVO()
        movie.id = 1

        mPresenter.onTapVideo(movie.id)
        verify {
             mView.navigateToYoutube(getDummyVideos()[0].key)
        }
    }

    @Test
    fun onUiReady_callDisplayLists() {
        val lifeCycleOwner = mock(LifecycleOwner::class.java)

        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mPresenter.onUiReady(lifeCycleOwner)
        verify {
            mView.displayPopularMoviesList(getDummyMovies())
            mView.displayTopRatedMoviesList(getDummyMovies())
            mView.displayShowcasesMoviesList(getDummyMovies())
            mView.displayGenresList(getDummnyGenres())
            mView.displayPopularActorsList(getDummyActors())
        }
    }

}