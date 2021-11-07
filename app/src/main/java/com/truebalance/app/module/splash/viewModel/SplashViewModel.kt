package com.truebalance.app.module.splash.viewModel

import com.truebalance.app.base.view.BaseViewModel
import com.truebalance.app.data.AppPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@HiltViewModel
class SplashViewModel @Inject constructor(val preference: AppPreference) :
    BaseViewModel() {

}