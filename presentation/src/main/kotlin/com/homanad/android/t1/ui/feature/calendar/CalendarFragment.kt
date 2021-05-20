package com.homanad.android.t1.ui.feature.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.t1.R
import com.homanad.android.t1.databinding.FragmentCalendarBinding
import com.homanad.android.t1.ui.feature.calendar.adapter.CalendarAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalendarFragment : BaseFragment() {

    private lateinit var binding: FragmentCalendarBinding

    private val calendarAdapter by lazy {
        CalendarAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calendar, container, false)
        return binding.root
    }

    override fun observeData() {

    }

    override fun setupViewModel() {

    }

    override fun updateUI() {
        with(binding) {
            recyclerDay.run {
                adapter = calendarAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                post {
                    smoothScrollToPosition(calendarAdapter.getSelectedPosition())
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CalendarFragment()
    }
}