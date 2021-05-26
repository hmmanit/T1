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
import com.homanad.android.domain.common.getDateOfMonth
import com.homanad.android.domain.common.getDayOfWeek
import com.homanad.android.t1.R
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
                        Log.d("aaaaaaaaaaaaa", position.toString())

                        if (position == 0) {
                            calendarPageAdapter.addPrevious(CalendarPageAdapter.DEFAULT_NUMBER_OF_DAYS)
                            pageDay.postDelayed({
                                setCurrentItem(CalendarPageAdapter.DEFAULT_NUMBER_OF_DAYS, false)
                            }, 100)
                        } else if (position == calendarPageAdapter.itemCount - 1) calendarPageAdapter.addNext(
                            CalendarPageAdapter.DEFAULT_NUMBER_OF_DAYS
                        )
                    }
                })
                setCurrentItem(calendarPageAdapter.itemCount / 2, true)
            }
            TabLayoutMediator(tabDay, pageDay) { tab, position ->
                val dayMillis = calendarPageAdapter.days[position]
                tab.text = dayMillis.getDayOfWeek() + "\n" + dayMillis.getDateOfMonth()
            }.attach()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CalendarFragment()
    }
}