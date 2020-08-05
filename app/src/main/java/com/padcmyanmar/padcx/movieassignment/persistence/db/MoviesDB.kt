package com.padcmyanmar.padcx.movieassignment.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcmyanmar.padcx.movieassignment.data.vos.*
import com.padcmyanmar.padcx.movieassignment.persistence.daos.MoviesDao

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/1/2020.
 */

@Database(entities = [MovieVO::class,GenresVO::class,
        UserVO::class,VideoVO::class,CountryVO::class]
            , version = 6, exportSchema = false)
abstract class MoviesDB : RoomDatabase() {
    companion object {
        val DB_NAME = "Movie.DB"
        var dbInstance: MoviesDB? = null

        fun getDBInstance(context: Context): MoviesDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MoviesDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun moviesDao(): MoviesDao
}