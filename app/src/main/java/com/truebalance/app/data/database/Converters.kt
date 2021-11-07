package com.truebalance.app.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.truebalance.app.module.dashboard.model.Result
import java.util.*

/**
 * Created by Musharib Ali on 6/11/21.
 * ali.musharib1@gmail.com
 */
class Converters {

    @TypeConverter
    fun getString(someObjects: List<String>?) = Gson().toJson(someObjects)

    @TypeConverter
    fun fromStringTimestamp(value: String?) =  Gson().fromJson(value, Array<String>::class.java).toList()


    @TypeConverter
    fun listToJson(value: List<Any>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String?) = Gson().fromJson(value, Array<Any>::class.java).toList()

    @TypeConverter
    fun listToJsonResult(value: List<Result>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToListResult(value: String?) = Gson().fromJson(value, Array<Result>::class.java).toList()


}