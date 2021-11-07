package com.truebalance.app.navigate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.truebalance.app.R
import com.truebalance.app.module.dashboard.view.MoviesActivity
import com.truebalance.app.module.splash.view.SplashFragment
import com.truebalance.app.utils.safeLet
import javax.inject.Inject

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

class AppNavigator @Inject constructor(private val activity: FragmentActivity) :
    AppNavigatorInterface {
    override fun navigator(
        command: Command,
        currentFragment: Fragment?,
        addFragment: Boolean?,
        b: Bundle?
    ) {
        val fragment: Fragment = when (command) {
            Command.SPLASH -> SplashFragment.newInstance()
            else -> SplashFragment.newInstance()
        }
        fragment.let {
            b?.let { v -> it.arguments = v }
            with(activity.supportFragmentManager.beginTransaction()) {
                if (addFragment == true) {
                    add(R.id.nav_container, it, it::class.java.canonicalName)
                    if (currentFragment != null)
                        hide(currentFragment)
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    addToBackStack(it::class.java.canonicalName).commit()
                } else {
                    replace(R.id.nav_container, it, it::class.java.canonicalName)
                    commitAllowingStateLoss()
                }


            }
        }

    }


    override fun navigateToActivity(command: Command, isFinish: Boolean?, b: Bundle?) {
        with(activity) {
            val intent: Intent = when (command) {
                Command.HOME -> Intent(this, MoviesActivity::class.java)
                else -> TODO()
            }
            safeLet(intent, b) { intent_, bundle ->
                intent_.putExtras(bundle)
            }
            startActivity(intent)

            if (isFinish == true) finish()

        }

    }


}


interface AppNavigatorInterface {
    fun navigator(
        command: Command,
        currentFragment: Fragment? = null,
        addFragment: Boolean? = false,
        b: Bundle? = null
    )

    fun navigateToActivity(command: Command, isFinish: Boolean? = false, b: Bundle? = null)
}

enum class Command {
    HOME,
    SPLASH,
}
