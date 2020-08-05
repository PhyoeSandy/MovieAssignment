package com.padcmyanmar.padcx.movieassignment.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/1/2020.
 */
@Entity(tableName = "genres")
data class GenresVO(
    @PrimaryKey
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String = ""
)