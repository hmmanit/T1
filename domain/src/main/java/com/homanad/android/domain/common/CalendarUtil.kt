package com.homanad.android.domain.common

import java.util.*

const val ONE_DAY_IN_MILLIS = 86400000
const val START_TIME_OF_THE_DAY = "00:00"
const val END_TIME_OF_THE_DAY = "23:59"

fun generateFromToday(): MutableList<Long> {
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

fun MutableList<Long>.addNumberOfNextDays(number: Int, currentDayInMillis: Long) {
    var count = 0

    var today = currentDayInMillis
    while (count < number) {
        today += ONE_DAY_IN_MILLIS
        count++
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

fun MutableList<Long>.addNumberOfPreviousDays(number: Int, currentDayInMillis: Long) {
    var count = 0

    var today = currentDayInMillis
    while (count < number) {
        today -= ONE_DAY_IN_MILLIS
        count++
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

fun Long.toDateTimeWithNewLine(): String {
    val calendar: Calendar = GregorianCalendar()
    calendar.timeInMillis = this
    var datetime = ""
    if (calendar.get(Calendar.DATE) < 10) datetime += '0'
    datetime += calendar.get(Calendar.DATE)
    datetime += "/"
    if (calendar.get(Calendar.MONTH) < 9) datetime += '0'
    datetime += calendar.get(Calendar.MONTH) + 1
    datetime += "/"
    datetime += calendar.get(Calendar.YEAR)
    datetime += "\n"
    if (calendar.get(Calendar.HOUR_OF_DAY) < 10) datetime += '0'
    datetime += calendar.get(Calendar.HOUR_OF_DAY)
    datetime += ":"
    if (calendar.get(Calendar.MINUTE) < 10) datetime += '0'
    datetime += calendar.get(Calendar.MINUTE)
    return datetime
}

fun Long.getStartOfToday(): Long {
    val calendar: Calendar = GregorianCalendar()
    calendar.timeInMillis = this
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    return calendar.timeInMillis
}

fun Long.getEndOfToday(): Long {
    val calendar: Calendar = GregorianCalendar()
    calendar.timeInMillis = this
    calendar.set(Calendar.HOUR_OF_DAY, 23)
    calendar.set(Calendar.MINUTE, 59)
    calendar.set(Calendar.SECOND, 59)
    calendar.set(Calendar.MILLISECOND, 999)
    return calendar.timeInMillis
}

fun Calendar.setDateTime(time: Long, hour: Int, minute: Int) {
    timeInMillis = time
    setTime(hour, minute)
}

fun Calendar.setTime(hour: Int, minute: Int) {
    set(Calendar.HOUR_OF_DAY, hour)
    set(Calendar.MINUTE, minute)
}

fun Int.getDayOfWeek(): String {
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

fun Long.getDateOfMonth(): String {
    val calendar: Calendar = GregorianCalendar()
    calendar.timeInMillis = this
    var dayOfMonth = ""
    dayOfMonth += calendar.get(Calendar.DATE)
    dayOfMonth += "/" + (calendar.get(Calendar.MONTH) + 1)
    return dayOfMonth
}

fun Long.getDateOfWeek(): String {
    val calendar: Calendar = GregorianCalendar()
    calendar.timeInMillis = this
    return calendar.get(Calendar.DAY_OF_WEEK).getDayOfWeek()
}