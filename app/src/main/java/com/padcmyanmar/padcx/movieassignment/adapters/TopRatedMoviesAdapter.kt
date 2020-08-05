package com.padcmyanmar.padcx.movieassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.movieassignment.R
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.delegates.MovieItemDelegate
import com.padcmyanmar.padcx.movieassignment.delegates.VideoItemDelegate
import com.padcmyanmar.padcx.movieassignment.views.viewholders.LargeMoviesViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class TopRatedMoviesAdapter(val delegate: VideoItemDelegate) : BaseRecyclerAdapter<LargeMoviesViewHolder, MovieVO>() {
    private var mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LargeMoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_top_rated_movies, parent, false)
        return LargeMoviesViewHolder(mDelegate, view)
    }
}