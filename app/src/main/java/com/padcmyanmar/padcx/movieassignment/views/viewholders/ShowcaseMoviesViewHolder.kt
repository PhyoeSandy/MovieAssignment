package com.padcmyanmar.padcx.movieassignment.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.delegates.VideoItemDelegate
import com.padcmyanmar.padcx.movieassignment.utils.IMAGE_URL
import com.padcmyanmar.padcx.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_showcases.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class ShowcaseMoviesViewHolder(private val delegate: VideoItemDelegate, itemView: View) : BaseViewHolder<MovieVO>(itemView) {

    init {
        itemView.btnPlay.setOnClickListener {
            mData?.let {
                delegate.onTapVideo(it.id)
            }
        }
    }


    override fun bindData(data: MovieVO) {
        mData = data

        itemView.tvName.text = data.movieName
        Glide.with(itemView.context)
            .load(IMAGE_URL + data.movieImage)
            .into(itemView.ivShowcase)
    }
}