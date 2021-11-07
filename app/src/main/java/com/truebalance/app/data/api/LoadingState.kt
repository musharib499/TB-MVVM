package com.truebalance.app.data.api

/**
 * Created by Musharib Ali on 6/11/21.
 * ali.musharib1@gmail.com
 */
@Suppress("DataClassPrivateConstructor")
data class LoadingState private constructor(val status: Status, val msg: String? = null) {
    companion object {
        val LOADED = LoadingState(Status.SUCCESS)
        val LOADING = LoadingState(Status.RUNNING)
        fun error(msg: String?) = LoadingState(Status.FAILED, msg)
    }

    enum class Status {
        RUNNING,
        SUCCESS,
        FAILED
    }
}