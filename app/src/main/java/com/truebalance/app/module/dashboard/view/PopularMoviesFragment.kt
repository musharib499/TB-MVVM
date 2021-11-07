package com.truebalance.app.module.dashboard.view

import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.truebalance.app.R
import com.truebalance.app.base.view.BaseFragment
import com.truebalance.app.databinding.FragmentPopularBinding
import com.truebalance.app.module.dashboard.viewModel.PopularMoviesViewModel
import com.truebalance.app.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@AndroidEntryPoint
class PopularMoviesFragment : BaseFragment<FragmentPopularBinding>(R.layout.fragment_popular) {

    private val viewModel by viewModels<PopularMoviesViewModel>()

    override fun viewModelSetup() {
        with(viewModel) {

            binding.model = this
            viewModelScope.launch {
                message.collect {
                    toast(it)
                }
                onClickItemLive.collect {
                    toast(it?.title)
                }
            }

        }

    }
}