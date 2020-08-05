package com.padcmyanmar.padcx.movieassignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.movieassignment.R
import com.padcmyanmar.padcx.movieassignment.activities.DetailsActivity
import com.padcmyanmar.padcx.movieassignment.adapters.PopularMoviesAdapter
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.GenreFragmentPresenter
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.impls.GenreFragmentPresenterImpl
import com.padcmyanmar.padcx.movieassignment.mvp.views.GenreFragmentView
import kotlinx.android.synthetic.main.fragment_genremovie.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/4/2020.
 */
class GenreMovieFragment : Fragment(), GenreFragmentView {

    private lateinit var mPresenter: GenreFragmentPresenter

    private lateinit var mPopularMoviesAdapter: PopularMoviesAdapter

    companion object{

        const val GENRE_ID ="GENRE_ID"

        fun newInstance(genreId:Int) : GenreMovieFragment{
            val fragment = GenreMovieFragment()
            val bundle = Bundle().apply {
                putInt(GENRE_ID,genreId) }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_genremovie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPresenter()
        setupRecyclerView()

        mPresenter.onUiReady(this, arguments!!.getInt(GENRE_ID))
    }

    private fun setupRecyclerView() {
        mPopularMoviesAdapter = PopularMoviesAdapter(mPresenter)
        with(rvGenreMovie){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mPopularMoviesAdapter
        }
    }

    private fun setupPresenter() {
        mPresenter = ViewModelProviders.of(this).get(GenreFragmentPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayGenreFragment(movies: List<MovieVO>) {
        mPopularMoviesAdapter.setNewData(movies.toMutableList())
    }

    override fun navigateToMovieDetail(movieId: Int) {
        startActivity(DetailsActivity.newIntent(requireContext(),movieId))
    }

    /*override fun displayGenresList(genres: List<GenresVO>) {
        tabGenre.addOnTabSelectedListener(object  : OnTabSelectedListener {
           override fun onTabSelected(tab: TabLayout.Tab?) {
               mPresenter.onTapGenreTabs(tab!!.position)
           }
       })
      }*/
}