package com.padcmyanmar.padcx.movieassignment.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.viewpod_movies.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class MovieViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate : Delegate ?= null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setupListener()
    }

    fun setupListener() {
        cardMovie.setOnClickListener {
            //mDelegate?.onTapMovie()
        }
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    interface Delegate {
        fun onTapMovie(movieId: Int)
    }
}