package com.padcmyanmar.padcx.movieassignment.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.delegates.MovieItemDelegate
import com.padcmyanmar.padcx.movieassignment.delegates.VideoItemDelegate
import com.padcmyanmar.padcx.movieassignment.utils.IMAGE_URL
import kotlinx.android.synthetic.main.item_top_rated_movies.view.*
import kotlinx.android.synthetic.main.viewpod_movies.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class LargeMoviesViewHolder(private val delegate: VideoItemDelegate, itemView: View) : AbstractBaseViewHolder(itemView) {

    init {
        itemView.ivTopRatedMovie.setOnClickListener {
            mData?.let {
                delegate.onTapVideo(it.id)
            }
        }

    }

    override fun bindData(data: MovieVO) {
        mData = data

        itemView.tvMovieName.text = data.movieName

        Glide.with(itemView.context)
            .load(IMAGE_URL + data.movieImage)
            .into(itemView.ivTopRatedMovie)
    }
}