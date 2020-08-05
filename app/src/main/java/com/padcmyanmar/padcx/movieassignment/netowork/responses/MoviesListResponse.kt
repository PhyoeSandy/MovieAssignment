package com.padcmyanmar.padcx.movieassignment.netowork.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
data class MoviesListResponse(
    @SerializedName("results") val data: ArrayList<MovieVO>? = arrayListOf()
)