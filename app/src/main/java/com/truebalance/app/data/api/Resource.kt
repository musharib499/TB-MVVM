package com.truebalance.app.data.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by Musharib Ali on 6/11/21.
 * ali.musharib1@gmail.com
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T? = null, message: String? = null): Resource<T> {
            return Resource(Status.SUCCESS, data, message)
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null, message: String? = null): Resource<T> {
            return Resource(Status.LOADING, data, message)
        }
    }
}

// Save data in database and get data from api

fun <T> loadData(
    localCall: () -> Flow<T>,
    networkCall: suspend () -> Resource<T>,
    saveCall: suspend (T) -> Unit
): Flow<Resource<T>> =
    flow {
        emit(Resource.loading())
        val responseStatus = networkCall.invoke()

        if (responseStatus.status == Resource.Status.SUCCESS) {
            emit(responseStatus)
            responseStatus.data?.let { saveCall(it) }


        } else if (responseStatus.status == Resource.Status.ERROR) {
            var flag = false
            localCall().collect {
                flag = (it == null)
                if (!flag) emit(Resource.success(it))

            }
            if (flag) emit(Resource.error(responseStatus.message ?: ""))

        }


    }.flowOn(Dispatchers.IO)

// Get data from local database
fun <T> loadData(networkCall: suspend () -> Resource<T>): Flow<Resource<T>> =
    flow {
        emit(Resource.loading())
        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Resource.Status.SUCCESS) {
            emit(responseStatus)


        } else if (responseStatus.status == Resource.Status.ERROR) {
            emit(responseStatus)
        }

    }.flowOn(Dispatchers.IO)


fun <T> loadData(databaseQuery: () -> Flow<T>): Flow<Resource<T>> =
    flow {
        databaseQuery().collect {
            emit(Resource.success(it, ""))
        }


    }.flowOn(Dispatchers.IO)



