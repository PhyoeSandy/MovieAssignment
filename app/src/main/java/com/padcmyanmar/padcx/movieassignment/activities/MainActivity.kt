package com.padcmyanmar.padcx.movieassignment.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.padcmyanmar.padcx.movieassignment.R
import com.padcmyanmar.padcx.movieassignment.adapters.*
import com.padcmyanmar.padcx.movieassignment.data.vos.GenresVO
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.data.vos.UserVO
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.MainPresenter
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.impls.MainPresenterImpl
import com.padcmyanmar.padcx.movieassignment.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mPresenter: MainPresenter

    private lateinit var mSliderAdapter: SliderAdapter
    private lateinit var mPopularMoviesAdapter: PopularMoviesAdapter
    private lateinit var mShowcasesMoviesAdapter: ShowcasesMoviesAdapter
    private lateinit var mActorAdapter: ActorAdapter
    private lateinit var mDynamicPagerAdapter: DynamicPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPresenter()
        setupRecyclerView()
        setUpViewPager2WithTabLayout()

        mPresenter.initPresenter(this)
    }

    private fun setUpViewPager2WithTabLayout() {
        mDynamicPagerAdapter = DynamicPagerAdapter(this)
        viewPagerMovie.adapter = mDynamicPagerAdapter
        tabGenre.getTabAt(0)?.select()
        viewPagerMovie.isUserInputEnabled = false;
    }

    private fun setupRecyclerView() {

        /*with(rvTopReatedMovie) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mSliderAdapter
        }*/
        mSliderAdapter = SliderAdapter(mPresenter)
        imageSlider.setSliderAdapter(mSliderAdapter)

        mPopularMoviesAdapter = PopularMoviesAdapter(mPresenter)
        with(rvPopularMovies) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mPopularMoviesAdapter
        }

        mShowcasesMoviesAdapter = ShowcasesMoviesAdapter(mPresenter)
        with(rvShowCases) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mShowcasesMoviesAdapter
        }

        mActorAdapter = ActorAdapter()
        with(rvActors) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mActorAdapter
        }
    }

    private fun setupPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.onUiReady(this)
    }

    override fun displayTopRatedMoviesList(movies: List<MovieVO>) {
        mSliderAdapter.addItems(movies.toMutableList())
    }

    override fun displayPopularMoviesList(movies: List<MovieVO>) {
        mPopularMoviesAdapter.setNewData(movies.toMutableList())
    }

    override fun displayShowcasesMoviesList(movies: List<MovieVO>) {
        mShowcasesMoviesAdapter.setNewData(movies.toMutableList())
    }

    override fun displayGenresList(genres: List<GenresVO>) {
        /*for(data in genres){
            tabGenre.addTab(tabGenre.newTab().setText(data.name))
        }

        tabGenre.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab) {
                Log.d("Position",tab!!.position.toString() )
            }
        })*/

        TabLayoutMediator( tabGenre, viewPagerMovie,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = genres[position].name
            }).attach()

        mDynamicPagerAdapter.setData(genres)
    }

    override fun displayPopularActorsList(actors: List<UserVO>) {
        mActorAdapter.setNewData(actors.toMutableList())
    }

    override fun navigateToDetails(movieId: Int) {
        startActivity(DetailsActivity.newIntent(this, movieId))
    }

    override fun navigateToYoutube(videoKey: String) {
        val webIntent = Intent( Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/watch?v=$videoKey"))
        startActivity(webIntent)
    }
}