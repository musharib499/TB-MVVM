package com.truebalance.app.data.api

import com.truebalance.app.BuildConfig
import com.truebalance.app.data.AppPreference
import com.truebalance.app.utils.APP_KEY
import okhttp3.*
import javax.inject.Inject

/**
 * Created by Musharib Ali on 6/11/21.
 * ali.musharib1@gmail.com
 */
class AuthInterceptor @Inject constructor(private val preference: AppPreference) : Interceptor,
    Authenticator {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url
            .newBuilder()
            .addQueryParameter(APP_KEY, BuildConfig.APP_KEY)
            .build()

        request = request.newBuilder()
            .addHeader("Authorization", preference.getAuthToken())
            .url(url)
            .build()

        return chain.proceed(request)
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        var requestAvailable: Request? = null
        try {
            requestAvailable = response.request.newBuilder()
                .addHeader("Authorization", "UUID.randomUUID().toString()")
                .build()
            return requestAvailable
        } catch (ex: Exception) {
        }
        return requestAvailable
    }
}