package com.padcmyanmar.padcx.movieassignment.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcmyanmar.padcx.movieassignment.mvp.views.BaseView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>, ViewModel() {
    protected var mView : T ?= null

    override fun initPresenter(view: T) {
        mView = view
    }
}