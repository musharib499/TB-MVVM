package com.truebalance.app.data.api

import javax.inject.Inject

/**
 * Created by Musharib Ali on 6/11/21.
 * ali.musharib1@gmail.com
 */
class ApiHelperImpl @Inject constructor(val apiService: ApiService) : BaseDataSource() {

    suspend fun topRatedMoviesApi() = getResult {
        apiService.topRatedMoviesApi()
    }
    suspend fun upcomingMoviesApi() = getResult {
        apiService.upcomingMoviesApi()
    }
    suspend fun popularMoviesApi() = getResult {
        apiService.popularMoviesApi()
    }
}