package com.padcmyanmar.padcx.movieassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.movieassignment.R
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.delegates.MovieItemDelegate
import com.padcmyanmar.padcx.movieassignment.views.viewholders.SmallMoviesViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class PopularMoviesAdapter(private val delegate: MovieItemDelegate) : BaseRecyclerAdapter<SmallMoviesViewHolder, MovieVO>() {
    private var mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallMoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movies, parent, false)
        return SmallMoviesViewHolder(mDelegate, view)
    }
}