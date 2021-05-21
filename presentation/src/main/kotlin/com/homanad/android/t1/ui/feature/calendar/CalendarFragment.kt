package com.homanad.android.t1.ui.feature.calendar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.t1.R
import com.homanad.android.t1.common.toDayModel
import com.homanad.android.t1.databinding.FragmentCalendarBinding
import com.homanad.android.t1.ui.feature.calendar.adapter.CalendarPageAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalendarFragment : BaseFragment() {

    private lateinit var binding: FragmentCalendarBinding

    private val calendarPageAdapter by lazy {
        CalendarPageAdapter(requireActivity())
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
            pageDay.run {
                adapter = calendarPageAdapter
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        if (position == 0){
                            calendarPageAdapter.addPrevious()
                            pageDay.post {
                                setCurrentItem(10, false)
                            }
                        }
                        else if (position == calendarPageAdapter.itemCount - 1) calendarPageAdapter.addNext()
                    }
                })
                setCurrentItem(10, true)
            }
            TabLayoutMediator(tabDay, pageDay) { tab, position ->
                val dayModel = calendarPageAdapter.days[position].toDayModel()
                tab.text = dayModel.dayOfWeek + "\n" + dayModel.dayOfMonth
            }.attach()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CalendarFragment()
    }
}