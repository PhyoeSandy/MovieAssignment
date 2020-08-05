package com.padcmyanmar.padcx.movieassignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.movieassignment.delegates.MovieItemDelegate
import com.padcmyanmar.padcx.movieassignment.mvp.views.GenreFragmentView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/4/2020.
 */
interface GenreFragmentPresenter : BasePresenter<GenreFragmentView>, MovieItemDelegate {
    fun onUiReady(lifecycleOwner: LifecycleOwner, genresId: Int)
}