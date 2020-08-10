package com.padcmyanmar.padcx.movieassignment.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.movieassignment.data.vos.UserVO
import com.padcmyanmar.padcx.movieassignment.utils.IMAGE_URL
import com.padcmyanmar.padcx.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.viewpod_users.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/4/2020.
 */
class UserViewHolder(itemView: View) : BaseViewHolder<UserVO>(itemView) {
    override fun bindData(data: UserVO) {
        mData = data

        itemView.tvActorName.text = data.name
        Glide.with(itemView.context)
            .load(IMAGE_URL + data.profile_image)
            .into(itemView.ivActor)
    }
}