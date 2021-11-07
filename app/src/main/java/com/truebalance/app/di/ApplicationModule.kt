package com.truebalance.app.di

import android.content.Context
import android.content.SharedPreferences
import com.truebalance.app.BuildConfig
import com.truebalance.app.data.AppPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(BuildConfig.APP_NAME, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideSessionManager(preferences: SharedPreferences): AppPreference =
        AppPreference(preferences)


}