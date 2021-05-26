package com.homanad.android.t1.ui.feature.statistic.vm

import androidx.lifecycle.ViewModel
import com.google.android.material.datepicker.MaterialDatePicker

class StatisticViewModel : ViewModel() {

    var dateInMillis = MaterialDatePicker.todayInUtcMilliseconds()

    var monthInMillis = MaterialDatePicker.thisMonthInUtcMilliseconds()

    var startDateInMillis = MaterialDatePicker.thisMonthInUtcMilliseconds()
    var endDateInMillis = MaterialDatePicker.todayInUtcMilliseconds()

}