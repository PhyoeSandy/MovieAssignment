package com.padcmyanmar.padcx.movieassignment.netowork.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.movieassignment.data.vos.UserVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/4/2020.
 */
data class ActorsListResponse(
    @SerializedName("results") val data: ArrayList<UserVO>? = arrayListOf()
)