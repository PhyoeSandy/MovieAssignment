package com.padcmyanmar.padcx.movieassignment.mvp.presenters

import com.padcmyanmar.padcx.movieassignment.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
interface BasePresenter<T: BaseView> {

    fun initPresenter(view: T)
}