package com.padcmyanmar.padcx.movieassignment.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.delegates.MovieItemDelegate
import com.padcmyanmar.padcx.movieassignment.utils.IMAGE_URL
import com.padcmyanmar.padcx.movieassignment.views.viewpods.MovieViewPod
import com.padcmyanmar.padcx.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_movies.view.*
import kotlinx.android.synthetic.main.viewpod_movies.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class SmallMoviesViewHolder(private val delegate: MovieItemDelegate, itemView: View) : BaseViewHolder<MovieVO>(itemView) {

    private val mViewPodMovie = itemView.vpMovie as MovieViewPod

    init {
        itemView.ivMovie.setOnClickListener {
            mData?.let {
                delegate.onTapMovie(it.id)
            }
        }
    }



    override fun bindData(data: MovieVO) {
        mData = data

        itemView.tvMovieTitle.text = data.movieName
        itemView.tvVote.text = data.voteCount.toString()
        itemView.rbVote.rating = data.voteRating.toFloat()

        Glide.with(itemView.context)
            .load(IMAGE_URL + data.movieImage)
            .into(itemView.ivMovie)

        //mViewPodMovie.setDelegate()
    }
}