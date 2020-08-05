package com.padcmyanmar.padcx.movieassignment.netowork.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.movieassignment.data.vos.GenresVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class GenreListResponse {
    @SerializedName("genres") val data: ArrayList<GenresVO>? = arrayListOf()
}