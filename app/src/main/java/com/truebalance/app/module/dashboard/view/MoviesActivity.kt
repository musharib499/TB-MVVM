package com.truebalance.app.module.dashboard.view

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.truebalance.app.R
import com.truebalance.app.base.view.BaseActivity
import com.truebalance.app.databinding.ActivityMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@AndroidEntryPoint
class MoviesActivity : BaseActivity<ActivityMoviesBinding>(R.layout.activity_movies) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onBottomNav()
    }


    private fun onBottomNav() {
        val navController = findNavController(R.id.nav_controller_activity_home)

        binding.navActivityHome.setupWithNavController(navController)
    }

}