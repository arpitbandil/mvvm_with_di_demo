package com.demo.virginmoneydemo.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.demo.virginmoneydemo.ui.people.PeopleFragment
import com.demo.virginmoneydemo.ui.rooms.RoomsListFragment

const val PEOPLES_PAGE_INDEX = 0
const val ROOM_LIST_PAGE_INDEX = 1

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        PEOPLES_PAGE_INDEX to { PeopleFragment() },
        ROOM_LIST_PAGE_INDEX to { RoomsListFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}
