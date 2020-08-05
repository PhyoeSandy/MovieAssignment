package com.padcmyanmar.padcx.movieassignment.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.padcx.movieassignment.data.vos.GenresVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class GenreListTypeConverter {

    @TypeConverter
    fun toString(genreList: ArrayList<GenresVO>) : String {
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun toGenreList(genreListJsonString: String) : ArrayList<GenresVO> {
        val genreListType = object : TypeToken<ArrayList<GenresVO>>() {}.type
        return Gson().fromJson(genreListJsonString,genreListType)
    }

}