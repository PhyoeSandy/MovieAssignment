package com.padcmyanmar.padcx.movieassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.movieassignment.R
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.delegates.VideoItemDelegate
import com.padcmyanmar.padcx.movieassignment.views.viewholders.SliderMoviesViewHolder
import com.smarteist.autoimageslider.SliderViewAdapter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/6/2020.
 */
class SliderAdapter(delegate: VideoItemDelegate) : SliderViewAdapter<SliderMoviesViewHolder>() {

    private var mDelegate = delegate
    var mSliderItems = arrayListOf<MovieVO>()

    override fun onCreateViewHolder(parent: ViewGroup?): SliderMoviesViewHolder {
        val view = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.item_top_rated_movies, parent, false)
        return SliderMoviesViewHolder(mDelegate, view)
    }

    override fun getCount(): Int {
        return mSliderItems.count()
    }

    override fun onBindViewHolder(viewHolder: SliderMoviesViewHolder?, position: Int) {
        viewHolder?.bindData(mSliderItems[position])
    }

    fun addItems(movies: List<MovieVO>) {
        this.mSliderItems.addAll(movies)
        notifyDataSetChanged()
    }
}