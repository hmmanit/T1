package com.homanad.android.t1.ui.feature.calendar.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.t1.R
import com.homanad.android.t1.ui.feature.home.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalendarPageFragment(private val timeInMillis: Long) : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar_page, container, false)
    }

    override fun observeData() {

    }

    override fun setupViewModel() {

    }

    override fun updateUI() {

    }

    companion object {
        @JvmStatic
        fun newInstance(timeInMillis: Long) = CalendarPageFragment(timeInMillis)
    }
}