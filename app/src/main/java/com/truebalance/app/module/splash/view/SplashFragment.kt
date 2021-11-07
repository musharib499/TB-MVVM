package com.truebalance.app.module.splash.view

import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.truebalance.app.R
import com.truebalance.app.base.view.BaseFragment
import com.truebalance.app.databinding.FragmentSplashBinding
import com.truebalance.app.module.splash.viewModel.SplashViewModel
import com.truebalance.app.navigate.Command
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {
    companion object {
        fun newInstance() = SplashFragment()
    }

    private val viewModel: SplashViewModel by viewModels()
    override fun viewModelSetup() {
        super.viewModelSetup()
        binding.model = viewModel
        with(viewModel) {
            viewModelScope.launch {
                delay(2000)
               navigator.navigateToActivity(Command.HOME,true)
            }
        }
    }
}