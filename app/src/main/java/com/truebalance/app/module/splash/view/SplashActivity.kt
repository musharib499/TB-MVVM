package com.truebalance.app.module.splash.view

import android.annotation.SuppressLint
import com.truebalance.app.R
import com.truebalance.app.base.view.BaseActivity
import com.truebalance.app.databinding.ActivitySplashBinding
import com.truebalance.app.navigate.Command
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */


@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun viewModelSetup() {
        super.viewModelSetup()
        navigator.navigator(Command.SPLASH)
    }


}