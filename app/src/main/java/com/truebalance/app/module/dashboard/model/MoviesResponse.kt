package com.truebalance.app.module.dashboard.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */



@Entity(tableName = "top_rated_movies")
data class TopRatedMoviesResponse(
    @PrimaryKey
    val id: Int? = 0,
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)

@Entity(tableName = "popular_movies")
data class PopularMoviesResponse(
    @PrimaryKey
    val id: Int? = 0,
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)
@Entity(tableName = "upcoming_movies")
data class UpcomingMoviesResponse(
    @PrimaryKey
    val id: Int? = 0,
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)

data class Result(
    val adult: Boolean?,
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val id: Int?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
)