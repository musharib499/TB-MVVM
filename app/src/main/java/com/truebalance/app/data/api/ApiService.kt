package com.truebalance.app.data.api

import com.truebalance.app.module.dashboard.model.PopularMoviesResponse
import com.truebalance.app.module.dashboard.model.TopRatedMoviesResponse
import com.truebalance.app.module.dashboard.model.UpcomingMoviesResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Musharib Ali on 6/11/21.
 * ali.musharib1@gmail.com
 */
interface ApiService {

    @GET("/3/movie/top_rated")
    suspend fun topRatedMoviesApi(): Response<TopRatedMoviesResponse>

    @GET("/3/movie/upcoming")
    suspend fun upcomingMoviesApi(): Response<UpcomingMoviesResponse>

    @GET("3/movie/popular")
    suspend fun popularMoviesApi(): Response<PopularMoviesResponse>


}