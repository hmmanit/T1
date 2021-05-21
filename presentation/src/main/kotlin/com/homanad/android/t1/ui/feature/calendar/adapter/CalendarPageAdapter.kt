package com.homanad.android.t1.ui.feature.calendar.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.homanad.android.t1.common.*
import com.homanad.android.t1.ui.feature.calendar.page.CalendarPageFragment

class CalendarPageAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    companion object {
        const val DEFAULT_NUMBER_OF_DAYS = 5
    }

    val days = generateFromToday()

    override fun getItemCount(): Int {
        return days.size
    }

    override fun createFragment(position: Int): Fragment {
        return CalendarPageFragment.newInstance(days[position])
    }

    fun addPrevious(count: Int) {
        days.addNumberOfPreviousDays(count, days[0])
        notifyDataSetChanged()
    }

    fun addNext(count: Int) {
        days.addNumberOfNextDays(count, days[days.size - 1])
        notifyDataSetChanged()
    }
}