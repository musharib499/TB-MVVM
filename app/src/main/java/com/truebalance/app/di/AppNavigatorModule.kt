package com.truebalance.app.di

import androidx.fragment.app.FragmentActivity
import com.truebalance.app.navigate.AppNavigator
import com.truebalance.app.navigate.AppNavigatorInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@Module
@InstallIn(ActivityComponent::class)
object AppNavigatorModule {

    @Provides
    @ActivityScoped
    fun bindNavigator(activity: FragmentActivity): AppNavigatorInterface = AppNavigator(activity)
}