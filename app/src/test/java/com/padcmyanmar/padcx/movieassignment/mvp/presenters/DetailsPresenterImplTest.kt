package com.padcmyanmar.padcx.movieassignment.mvp.presenters

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.padcmyanmar.padcx.movieassignment.data.dummy.getDummyActors
import com.padcmyanmar.padcx.movieassignment.data.dummy.getDummyCreators
import com.padcmyanmar.padcx.movieassignment.data.dummy.getDummyMovies
import com.padcmyanmar.padcx.movieassignment.data.model.MoviesModel
import com.padcmyanmar.padcx.movieassignment.data.model.impls.MockMoviesModelImpl
import com.padcmyanmar.padcx.movieassignment.data.model.impls.MoviesModelImpl
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.impls.DetailsPresenterImpl
import com.padcmyanmar.padcx.movieassignment.mvp.views.DetailsView
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
class DetailsPresenterImplTest {

    private lateinit var mPresenter: DetailsPresenterImpl

    @RelaxedMockK
    private lateinit var mView: DetailsView

    private lateinit var mMoviesModel: MoviesModel

    @Before
    fun setupPresenter() {
        MockKAnnotations.init(this)

        MoviesModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMoviesModel = MockMoviesModelImpl

        mPresenter = DetailsPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = this.mMoviesModel
    }

    @Test
    fun onUiReady_callDisplayLists() {

        val lifecycleOwner = mock(LifecycleOwner::class.java)

        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onUiReady(lifecycleOwner, 1)
        verify {
            //mView.displayCreatorsList(getDummyCreators())
            //mView.displayActorsList(getDummyActors())
            mView.displayDetailsData(getDummyMovies()[0])
        }
    }

}