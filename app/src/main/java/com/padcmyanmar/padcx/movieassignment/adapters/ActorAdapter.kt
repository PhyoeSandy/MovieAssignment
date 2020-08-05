package com.padcmyanmar.padcx.movieassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.movieassignment.R
import com.padcmyanmar.padcx.movieassignment.data.vos.UserVO
import com.padcmyanmar.padcx.movieassignment.views.viewholders.UserViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/4/2020.
 */
class ActorAdapter : BaseRecyclerAdapter<UserViewHolder, UserVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_users, parent, false)
        return UserViewHolder(view)
    }
}