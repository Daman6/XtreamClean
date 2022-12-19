package com.example.xtreamclean.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.xtreamclean.ui.AllFragment
import com.example.xtreamclean.ui.TodayFragment
import com.example.xtreamclean.ui.TomorrowFragment
import com.example.xtreamclean.ui.WeekFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity, private var totalCount: Int) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TodayFragment()
            1 -> TomorrowFragment()
            2 -> WeekFragment()
            3 -> AllFragment()
            else -> TodayFragment()
        }
    }
}
