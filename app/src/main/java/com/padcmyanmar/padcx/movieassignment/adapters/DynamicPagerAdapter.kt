package com.padcmyanmar.padcx.movieassignment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.padcmyanmar.padcx.movieassignment.data.vos.GenresVO
import com.padcmyanmar.padcx.movieassignment.fragments.GenreMovieFragment

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/5/2020.
 */
class DynamicPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private var genreList:List<Any> = emptyList()

    override fun getItemCount(): Int = genreList.size

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> GenreMovieFragment.newInstance((genreList[position] as GenresVO).id)
            else -> GenreMovieFragment.newInstance((genreList[position] as GenresVO).id)
        }
    }

    fun setData(data: List<Any>) {
        genreList = data
        notifyDataSetChanged()
    }
}