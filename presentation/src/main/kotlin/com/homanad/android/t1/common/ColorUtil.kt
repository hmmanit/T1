package com.homanad.android.t1.common

import android.content.Context
import android.graphics.Color
import android.util.Log
import com.homanad.android.t1.R

fun getLightColors(context: Context) = context.resources.getIntArray(R.array.lightColors)

fun getColors(context: Context): List<String> {
    val lightColors = getLightColors(context)
    return lightColors.map { it.toHexStringColor() }
}

fun Int.toHexStringColor(): String {
    Log.d("toHexStringColor", "#${Integer.toHexString(this)}")
    return "#${Integer.toHexString(this)}"
}

fun String.toIntColor(): Int {
    Log.d("toIntColor", this)
    return Color.parseColor(this)
}