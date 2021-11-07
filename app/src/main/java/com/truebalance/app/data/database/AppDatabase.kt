package com.truebalance.app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.truebalance.app.BuildConfig
import com.truebalance.app.module.dashboard.dao.MoviesDao
import com.truebalance.app.module.dashboard.model.PopularMoviesResponse
import com.truebalance.app.module.dashboard.model.TopRatedMoviesResponse
import com.truebalance.app.module.dashboard.model.UpcomingMoviesResponse

/**
 * Created by Musharib Ali on 6/11/21.
 * ali.musharib1@gmail.com
 */
@Database(entities = [TopRatedMoviesResponse::class,UpcomingMoviesResponse::class,PopularMoviesResponse::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, BuildConfig.APP_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

}