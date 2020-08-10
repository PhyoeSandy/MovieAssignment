package com.padcmyanmar.padcx.movieassignment.views.viewholders

import android.view.View
import com.padcmyanmar.padcx.movieassignment.data.vos.GenresVO
import com.padcmyanmar.padcx.shared.views.viewholders.BaseViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class GenreViewHolder(itemView: View) : BaseViewHolder<GenresVO>(itemView) {

    override fun bindData(data: GenresVO) {
        //itemView.tvGenre.text = data.name
    }
}