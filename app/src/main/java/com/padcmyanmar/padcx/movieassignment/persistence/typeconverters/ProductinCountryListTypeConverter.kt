package com.padcmyanmar.padcx.movieassignment.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.padcx.movieassignment.data.vos.CountryVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/2/2020.
 */
class ProductinCountryListTypeConverter {

    @TypeConverter
    fun toString(countryList: ArrayList<CountryVO>) : String {
        return Gson().toJson(countryList)
    }

    @TypeConverter
    fun toGenreList(countryListJsonString: String) : ArrayList<CountryVO> {
        val countryListType = object : TypeToken<ArrayList<CountryVO>>() {}.type
        return Gson().fromJson(countryListJsonString,countryListType)
    }
}