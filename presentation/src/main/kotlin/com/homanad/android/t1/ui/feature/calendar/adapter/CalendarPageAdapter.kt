package com.homanad.android.t1.ui.feature.calendar.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.homanad.android.t1.common.generateFromToday
import com.homanad.android.t1.ui.feature.calendar.page.CalendarPageFragment

class CalendarPageAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    val days = generateFromToday()

    override fun getItemCount(): Int {
        return days.size
    }

    override fun createFragment(position: Int): Fragment {
        return CalendarPageFragment.newInstance(days[position])
    }
}