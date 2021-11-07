package com.truebalance.app.module.dashboard.repository

import com.truebalance.app.data.api.ApiHelperImpl
import com.truebalance.app.data.api.BaseDataSource
import com.truebalance.app.data.api.loadData
import com.truebalance.app.module.dashboard.dao.MoviesDao
import javax.inject.Inject

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

class MoviesRepository @Inject constructor(
    private val api: ApiHelperImpl,
    private val local: MoviesDao
) :
    BaseDataSource() {

    fun topRatedMoviesApi() =
        loadData(
            localCall = { local.topRatedMoviesResponse() },
            networkCall = { api.topRatedMoviesApi() },
            saveCall = {
                local.insertTopRated(it)
            })

    fun upcomingMoviesApi() =
        loadData(
            localCall = { local.upcomingMoviesResponse() },
            networkCall = { api.upcomingMoviesApi() },
            saveCall = {
                local.insertUpcoming(it)
            })

    fun popularMoviesApi() =
        loadData(
            localCall = { local.popularMoviesResponse() },
            networkCall = { api.popularMoviesApi() },
            saveCall = {
                local.insertPopular(it)
            })
}