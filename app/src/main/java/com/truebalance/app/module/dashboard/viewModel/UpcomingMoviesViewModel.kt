package com.truebalance.app.module.dashboard.viewModel

import androidx.lifecycle.viewModelScope
import com.truebalance.app.base.view.BaseViewModel
import com.truebalance.app.data.api.Resource
import com.truebalance.app.module.dashboard.model.Result
import com.truebalance.app.module.dashboard.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@HiltViewModel
class UpcomingMoviesViewModel @Inject constructor(
    private val repo: MoviesRepository
) : BaseViewModel() {

    private val _onClickItemLive = MutableSharedFlow<Result?>()
    val onClickItemLive = _onClickItemLive.asSharedFlow()


    private val _listMovieItem = MutableStateFlow<List<Result>?>(listOf())
    val listMovieItem = _listMovieItem.asStateFlow()


    init {
        upcomingMoviesApi()
    }


    private fun upcomingMoviesApi() = viewModelScope.launch {
        repo.upcomingMoviesApi().collect {
            when (it.status) {
                Resource.Status.LOADING -> {
                    message.emit(it.message)
                }
                Resource.Status.ERROR -> {
                    message.emit(it.message)
                }
                Resource.Status.SUCCESS -> {
                    it.data?.let { data ->
                        _listMovieItem.emit(data.results)

                    }
                    message.emit(it.message)

                }

            }
        }
    }
}


