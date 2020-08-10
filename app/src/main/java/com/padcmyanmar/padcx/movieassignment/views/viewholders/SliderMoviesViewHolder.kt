package com.padcmyanmar.padcx.movieassignment.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.delegates.VideoItemDelegate
import com.padcmyanmar.padcx.movieassignment.utils.IMAGE_URL
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.item_top_rated_movies.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class SliderMoviesViewHolder(private val delegate: VideoItemDelegate, itemView: View):
        SliderViewAdapter.ViewHolder(itemView) {

    private lateinit var mData : MovieVO

    init {
        itemView.btnPlay.setOnClickListener {
            mData?.let {
                delegate.onTapVideo(it.id)
            }
        }
    }

    fun bindData(data: MovieVO) {
       mData = data

       itemView.tvMovieName.text = data.movieName
       Glide.with(itemView.context)
           .load(IMAGE_URL + data.movieImage)
           .into(itemView.ivTopRatedMovie)
   }
}