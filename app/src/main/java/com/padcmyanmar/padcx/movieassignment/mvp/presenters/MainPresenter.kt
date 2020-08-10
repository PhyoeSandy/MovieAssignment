package com.padcmyanmar.padcx.movieassignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.movieassignment.delegates.MovieItemDelegate
import com.padcmyanmar.padcx.movieassignment.delegates.VideoItemDelegate
import com.padcmyanmar.padcx.movieassignment.mvp.views.MainView
import com.padcmyanmar.padcx.shared.mvp.presenters.BasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
interface MainPresenter : BasePresenter<MainView>, MovieItemDelegate, VideoItemDelegate {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}