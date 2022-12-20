package com.example.xtreamclean.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.xtreamclean.ui.AllFragment
import com.example.xtreamclean.ui.TodayFragment
import com.example.xtreamclean.ui.TomorrowFragment
import com.example.xtreamclean.ui.WeekFragment
import com.example.xtreamclean.ui.elementDetailTabFragments.AboutFragment
import com.example.xtreamclean.ui.elementDetailTabFragments.ElementOverviewFragment
import com.example.xtreamclean.ui.propertyDetailTabFraments.ElementFragment
import com.example.xtreamclean.ui.propertyDetailTabFraments.OverviewFragment

class ElementDetailViewPagerAdapter(fragmentActivity: FragmentActivity, private var totalCount: Int) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ElementOverviewFragment()
            1 -> AboutFragment()
            else -> ElementOverviewFragment()
        }
    }
}
