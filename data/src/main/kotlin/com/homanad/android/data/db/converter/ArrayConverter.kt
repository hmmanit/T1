package com.homanad.android.data.db.converter

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object ArrayConverter {

    @TypeConverter
    @JvmStatic
    fun convertToString(strings: List<String>): String {
        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return adapter.toJson(strings)
    }

    @TypeConverter
    @JvmStatic
    fun convertToArray(strings: String): List<String> {
        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return adapter.fromJson(strings) ?: listOf()
    }
}