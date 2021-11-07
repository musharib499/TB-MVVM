package com.truebalance.app.module.dashboard.viewModel

import com.truebalance.app.base.view.BaseViewModel
import com.truebalance.app.module.dashboard.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@HiltViewModel
class MoviesViewModel @Inject constructor(val repo: MoviesRepository) : BaseViewModel() {
}