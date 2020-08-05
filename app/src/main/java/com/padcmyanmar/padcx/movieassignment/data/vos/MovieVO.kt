package com.padcmyanmar.padcx.movieassignment.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.movieassignment.persistence.typeconverters.GenreListTypeConverter
import com.padcmyanmar.padcx.movieassignment.persistence.typeconverters.ProductinCountryListTypeConverter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 7/31/2020.
 */
@Entity(tableName = "movie")
@TypeConverters(GenreListTypeConverter::class, ProductinCountryListTypeConverter::class)
data class MovieVO(
    @PrimaryKey
    @SerializedName("id") var id:Int = 0,
    @SerializedName("vote_average") var voteRating: Double = 0.0,
    @SerializedName("vote_count") var voteCount: Int = 0,
    @SerializedName("poster_path") var movieImage: String = "",
    @SerializedName("original_title") var movieName: String ="",
    @SerializedName("genres") var genres: ArrayList<GenresVO> = arrayListOf(),
    @SerializedName("overview") var description: String = "",
    @SerializedName("production_countries") var productionCountry: ArrayList<CountryVO> = arrayListOf(),
    @SerializedName("key") var videoKey: String = "",
    var status: Int = 0  // 0 for top_rated, 1 for popular, 2 for now_playing

   // @SerializedName("release_date") val releasedDate: Date
/*
    @SerializedName("production_companies") val productionCompany: ArrayList<CompanyVO> = arrayListOf()
*/

)