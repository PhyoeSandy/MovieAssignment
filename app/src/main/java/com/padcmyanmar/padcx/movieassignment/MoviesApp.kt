package com.padcmyanmar.padcx.movieassignment

import android.app.Application
import com.padcmyanmar.padcx.movieassignment.data.model.impls.MoviesModelImpl

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/3/2020.
 */
class MoviesApp : Application() {
    override fun onCreate() {
        super.onCreate()

        MoviesModelImpl.initDatabase(this)
    }
}