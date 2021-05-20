package com.homanad.android.t1.common

import android.util.Log
import com.homanad.android.t1.model.DayModel
import java.util.*

const val ONE_DAY_IN_MILLIS = 86400000

fun generateFromToday(): List<Long> {
    val today = System.currentTimeMillis()
    val days = mutableListOf(today)

//    var up = today
//    var down = today
//    while (days.size < 21) {
//        down -= ONE_DAY_IN_MILLIS
//        up += ONE_DAY_IN_MILLIS
//        days.add(0, down)
//        days.add(up)
//    }
    days.addPreviousTenDays(today)
    days.addNextTenDays(today)
    days.forEach {
        Log.d("dayyyyyyyy:\n", getDateString(it))
    }
    return days
}

fun MutableList<Long>.addNextTenDays(currentDayInMillis: Long) {
    val mSize = size

    var today = currentDayInMillis
    while (size < mSize + 10) {
        today += ONE_DAY_IN_MILLIS
        add(today)
    }
}

fun MutableList<Long>.addPreviousTenDays(currentDayInMillis: Long) {
    val mSize = size

    var today = currentDayInMillis
    while (size < mSize + 10) {
        today -= ONE_DAY_IN_MILLIS
        add(0, today)
    }
}

//fun generatePreviousTenDays(currentDayInMillis: Long): List<Long> {
//    val days = mutableListOf<Long>()
//
//    var today = currentDayInMillis
//    while (days.size < 10) {
//        today -= ONE_DAY_IN_MILLIS
//        days.add(0, today)
//    }
//    return days
//}

fun getDateString(timestamp: Long): String {
    val calendar: Calendar = GregorianCalendar()
    calendar.timeInMillis = timestamp
    var datetime = ""
    if (calendar.get(Calendar.DATE) < 10) datetime += '0'
    datetime += calendar.get(Calendar.DATE)
    datetime += "/"
    if (calendar.get(Calendar.MONTH) < 9) datetime += '0'
    datetime += calendar.get(Calendar.MONTH) + 1
    datetime += "/"
    datetime += calendar.get(Calendar.YEAR)
//        datetime += " "
//        if (calendar.get(Calendar.HOUR_OF_DAY) < 10) datetime += '0'
//        datetime += calendar.get(Calendar.HOUR_OF_DAY)
//        datetime += ":"
//        if (calendar.get(Calendar.MINUTE) < 10) datetime += '0'
//        datetime += calendar.get(Calendar.MINUTE)
    return datetime
}

fun Long.toDayModel(): DayModel {
    val calendar: Calendar = GregorianCalendar()
    calendar.timeInMillis = this
    var dayOfMonth = ""
    dayOfMonth += calendar.get(Calendar.DATE)
    dayOfMonth += "/" + (calendar.get(Calendar.MONTH) + 1)

    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK).getDay()

    return DayModel(dayOfWeek, dayOfMonth)
}

fun Int.getDay(): String {
    return when (this) {
        Calendar.SUNDAY -> "Sun"
        Calendar.MONDAY -> "Mon"
        Calendar.TUESDAY -> "Tue"
        Calendar.WEDNESDAY -> "Wed"
        Calendar.THURSDAY -> "Thu"
        Calendar.FRIDAY -> "Fri"
        Calendar.SATURDAY -> "Sat"
        else -> {
            return ""
        }
    }
}

fun Long.getStartOfToday(): Long {
    val calendar: Calendar = GregorianCalendar()
    calendar.timeInMillis = this
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    Log.d("aaaaaaaaaaaaaa", calendar.timeInMillis.toString())
    return calendar.timeInMillis
}

fun Long.getEndOfToday(): Long {
    val calendar: Calendar = GregorianCalendar()
    calendar.timeInMillis = this
    calendar.set(Calendar.HOUR_OF_DAY, 23)
    calendar.set(Calendar.MINUTE, 59)
    calendar.set(Calendar.SECOND, 59)
    calendar.set(Calendar.MILLISECOND, 999)
    Log.d("aaaaaaaaaaaaaa", calendar.timeInMillis.toString())
    return calendar.timeInMillis
}