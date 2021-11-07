package com.truebalance.app.di

import com.truebalance.app.BuildConfig
import com.truebalance.app.data.AppPreference
import com.truebalance.app.data.api.ApiHelperImpl
import com.truebalance.app.data.api.ApiService
import com.truebalance.app.data.api.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Musharib Ali on 7/11/21.
 * ali.musharib1@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private var baseUrl = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideAuthToken(preference: AppPreference): AuthInterceptor = AuthInterceptor(preference)


    @Provides
    fun provideOkHttpAuth(authInterceptor: AuthInterceptor) = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .authenticator(authInterceptor)
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiService: ApiService): ApiHelperImpl = ApiHelperImpl(apiService)

}