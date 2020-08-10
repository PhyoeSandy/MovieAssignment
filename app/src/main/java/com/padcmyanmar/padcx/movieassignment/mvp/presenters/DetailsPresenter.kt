package com.padcmyanmar.padcx.movieassignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.movieassignment.mvp.views.DetailsView
import com.padcmyanmar.padcx.shared.mvp.presenters.BasePresenter

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
interface DetailsPresenter : BasePresenter<DetailsView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner, movieId: Int)
}