package com.padcmyanmar.padcx.movieassignment.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/4/2020.
 */
@Entity(tableName = "user")
data class UserVO (
    @PrimaryKey
    @SerializedName("id") var id:Int =0,
    @SerializedName("name") var name:String = "",
    @SerializedName("profile_path") var profile_image: String = "",
    var status: Int = 0 // 0 for actors, 1 for creators
)