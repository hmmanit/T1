package com.homanad.android.domain.common

import java.text.SimpleDateFormat
import java.util.*

const val ONE_DAY_IN_MILLIS = 86400000
const val START_TIME_OF_THE_DAY = "00:00"
const val END_TIME_OF_THE_DAY = "23:59"

const val yyyy_MM_dd = "yyyy-MM-dd"   // 2018-07-14
const val dd_MMM_yyyy = "dd-MMM-yyyy"   // 14-Jul-2018
const val dd_separate_MM_separate_yyyy = "dd/MM/yyyy"   // 14/07/2018
const val MMM_space_dd_space_yyyy = "MMM dd yyyy"   // Jul 14 2018
const val dd_space_MMM_space_yyyy = "dd MMM yyyy"   // 14 Jul 2018
const val E_comma_MMM_space_dd_space_yyyy = "E, MMM dd yyyy"   // Sat, Jul 14 2018
const val h_colon_mm_space_a = "h:mm a"   // 12:08 PM
const val EEEE_coma_MMM_space_dd_comma_yyyy_space_HH_colon_mm_colon_ss_space_a =
    "EEEE, MMM dd, yyyy HH:mm:ss a"   // 	Saturday, Jul 14, 2018 14:31:06 PM
const val yyyy_MM_dd_apostrophe_T_apostrophe_HH_colon_mm_colon_ssZ =
    "yyyy-MM-dd'T'HH:mm:ssZ"   // 2018-07-14T14:31:30+0530
const val hh_space_apostrophe_o_2apostrophe_clock_apostrophe_space_a_comma_space_zzzz =
    "hh 'o''clock' a, zzzz"   // “12 o’clock PM, Pacific Daylight Time”
const val K_colon_mm_space_a_comma_space_z = "K:mm a, z"   // 	0:08 PM, PDT

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
        else -> ""
    }
}

fun Int.getMonthOfYear(): String {
    return when (this) {
        Calendar.JANUARY -> "Jan"
        Calendar.FEBRUARY -> "Feb"
        Calendar.MARCH -> "Mar"
        Calendar.APRIL -> "April"
        Calendar.MAY -> "May"
        Calendar.JUNE -> "Jun"
        Calendar.JULY -> "Jul"
        Calendar.AUGUST -> "Aug"
        Calendar.SEPTEMBER -> "Sep"
        Calendar.OCTOBER -> "Oct"
        Calendar.NOVEMBER -> "Nov"
        Calendar.DECEMBER -> "Dec"
        else -> ""
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

fun Long.getDayOfWeek(): String {
    val calendar: Calendar = GregorianCalendar()
    calendar.timeInMillis = this
    return calendar.get(Calendar.DAY_OF_WEEK).getDayOfWeek()
}

fun Long.getDateMonthYear(): String {
    val calendar: Calendar = GregorianCalendar()
    calendar.timeInMillis = this
    var dateMonthYear = ""
    dateMonthYear += calendar.get(Calendar.DATE)
    dateMonthYear += " " + calendar.get(Calendar.MONTH).getMonthOfYear()
    dateMonthYear += " " + calendar.get(Calendar.YEAR)

    return dateMonthYear
}

fun Long.getDateMonthYear(pattern: String): String {
    val formatter = SimpleDateFormat(pattern, Locale.getDefault())
    return formatter.format(Date(this))
}