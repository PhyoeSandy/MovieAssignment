package com.padcmyanmar.padcx.movieassignment.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.movieassignment.R
import com.padcmyanmar.padcx.movieassignment.adapters.ActorAdapter
import com.padcmyanmar.padcx.movieassignment.adapters.CreatorAdapter
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.data.vos.UserVO
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.DetailsPresenter
import com.padcmyanmar.padcx.movieassignment.mvp.presenters.impls.DetailsPresenterImpl
import com.padcmyanmar.padcx.movieassignment.mvp.views.DetailsView
import com.padcmyanmar.padcx.movieassignment.utils.IMAGE_URL
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_details.btnBack

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class DetailsActivity : AppCompatActivity(), DetailsView {

    companion object {
        const val IE_MOVIE_ID = "IE_MOVIE_ID"

        fun newIntent(context: Context, movieId: Int) : Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(IE_MOVIE_ID,movieId)
            return intent
        }
    }

    private lateinit var mPresenter : DetailsPresenter
    private lateinit var mActorAdapter: ActorAdapter
    private lateinit var mCreatorAdapter: CreatorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setupPresenter()
        setupRecyclerView()

        mPresenter.onUiReady(this, intent.getIntExtra(IE_MOVIE_ID,0))

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        mActorAdapter = ActorAdapter()
        with(rvActorsInDetails) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mActorAdapter
        }

        mCreatorAdapter = CreatorAdapter()
        with(rvCreatorsInDetails) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mCreatorAdapter
        }
    }

    private fun setupPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayDetailsData(movie: MovieVO) {
        tvMovieName.text = movie.movieName
        Glide.with(this)
            .load(IMAGE_URL + movie.movieImage)
            .into(ivBackgroundMovie)
    }

    override fun displayActorsList(actors: List<UserVO>) {
        mActorAdapter.setNewData(actors.toMutableList())
    }

    override fun displayCreatorsList(creators: List<UserVO>) {
        mCreatorAdapter.setNewData(creators.toMutableList())
    }
}