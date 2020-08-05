package com.padcmyanmar.padcx.movieassignment.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
@Entity(tableName = "country")
data class CountryVO(
    @PrimaryKey
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String = ""
)