package com.padcmyanmar.padcx.movieassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.movieassignment.R
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.delegates.MovieItemDelegate
import com.padcmyanmar.padcx.movieassignment.delegates.VideoItemDelegate
import com.padcmyanmar.padcx.movieassignment.views.viewholders.ShowcaseMoviesViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class ShowcasesMoviesAdapter(val delegate: VideoItemDelegate) : BaseRecyclerAdapter<ShowcaseMoviesViewHolder, MovieVO>() {

    private val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowcaseMoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_showcases, parent, false)
        return ShowcaseMoviesViewHolder(mDelegate, view)
    }

}