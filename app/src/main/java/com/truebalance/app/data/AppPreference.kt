package com.truebalance.app.data

import android.content.SharedPreferences
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Musharib Ali on 6/11/21.
 * ali.musharib1@gmail.com
 */
const val IS_LOGIN = "isLogin"
const val USER_INFO = "user_info"
const val USER_TOKEN = "user_token"
const val SELECTED_LANGUAGE = "language"


@Singleton
class AppPreference @Inject constructor(private val preferences: SharedPreferences) {

    fun getString(key: String): String? {

        return preferences.getString(key, "")
    }

    fun putString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    fun getAuthToken(): String {

        return preferences.getString(USER_TOKEN, "") ?: ""
    }

    fun putAuthToken(value: String) {
        preferences.edit().putString(USER_TOKEN, "Bearer $value").apply()
    }

    fun getInt(key: String): Int? {

        return preferences.getInt(key, -1)
    }

    fun putInt(key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }

    fun getBoolean(key: String): Boolean? {

        return preferences.getBoolean(key, false)
    }

    fun putBoolean(key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }

    fun getIsLogin(): Boolean? {

        return preferences.getBoolean(IS_LOGIN, false)
    }

    fun putIsLogin(value: Boolean) {
        preferences.edit().putBoolean(IS_LOGIN, value).apply()
    }

    fun <T> putObject(key: String, obj: T) {
        obj?.let {
            val value = Gson().toJson(obj)
            preferences.edit().putString(key, value).apply()
        }

    }

    fun <T> getDataObject(key: String, clazz: Class<T>): T? {
        val string: String? = preferences.getString(key, null)
        if (string.isNullOrBlank()) return null

        return Gson().fromJson(string, clazz)

    }

}
