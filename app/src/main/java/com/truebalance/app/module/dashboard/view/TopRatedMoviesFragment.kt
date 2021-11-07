package com.truebalance.app.module.dashboard.view

import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.truebalance.app.R
import com.truebalance.app.base.view.BaseFragment
import com.truebalance.app.databinding.FragmentTopRatedMoviesBinding
import com.truebalance.app.module.dashboard.viewModel.TopRatedMoviesViewModel
import com.truebalance.app.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@AndroidEntryPoint
class TopRatedMoviesFragment :
    BaseFragment<FragmentTopRatedMoviesBinding>(R.layout.fragment_top_rated_movies) {
    private val viewModel by viewModels<TopRatedMoviesViewModel>()
    override fun viewModelSetup() {
        with(viewModel) {
            binding.model = this
            viewModelScope.launch {
                message.collect {
                    toast(it)
                }
                onClickItemLive.collect {
                    toast(it.title)
                }
            }

        }

    }
}
