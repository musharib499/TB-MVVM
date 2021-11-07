package com.truebalance.app.module.dashboard.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.truebalance.app.module.dashboard.model.PopularMoviesResponse
import com.truebalance.app.module.dashboard.model.TopRatedMoviesResponse
import com.truebalance.app.module.dashboard.model.UpcomingMoviesResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopRated(user: TopRatedMoviesResponse)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpcoming(user: UpcomingMoviesResponse)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopular(user: PopularMoviesResponse)

    @Query("Select * from top_rated_movies")
    fun topRatedMoviesResponse(): Flow<TopRatedMoviesResponse>

    @Query("Select * from popular_movies")
    fun popularMoviesResponse(): Flow<PopularMoviesResponse>

    @Query("Select * from upcoming_movies")
    fun upcomingMoviesResponse(): Flow<UpcomingMoviesResponse>

}