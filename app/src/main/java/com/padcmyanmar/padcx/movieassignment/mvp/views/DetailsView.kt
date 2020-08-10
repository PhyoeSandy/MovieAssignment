package com.padcmyanmar.padcx.movieassignment.mvp.views

import com.padcmyanmar.padcx.movieassignment.data.vos.MovieVO
import com.padcmyanmar.padcx.movieassignment.data.vos.UserVO
import com.padcmyanmar.padcx.shared.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
interface DetailsView : BaseView {
    fun displayDetailsData(movie: MovieVO)
    fun displayActorsList(actors: List<UserVO>)
    fun displayCreatorsList(creators: List<UserVO>)
}