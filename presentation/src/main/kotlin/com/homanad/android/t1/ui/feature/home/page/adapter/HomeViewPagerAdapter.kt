package com.homanad.android.t1.ui.feature.home.page.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.homanad.android.t1.ui.feature.home.page.HomePageFragment
import com.homanad.android.t1.ui.feature.home.page.type.Page

class HomeViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    val pages = listOf(
        Page.TASKS, Page.BOARDS, Page.OTHERS
    )

    override fun getItemCount(): Int {
        return pages.size
    }

    override fun createFragment(position: Int): Fragment {
        return HomePageFragment.newInstance(pages[position].id)
    }
}