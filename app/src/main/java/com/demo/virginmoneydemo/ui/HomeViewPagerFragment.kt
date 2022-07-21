package com.demo.virginmoneydemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.demo.virginmoneydemo.R
import com.demo.virginmoneydemo.adapters.HomePagerAdapter
import com.demo.virginmoneydemo.adapters.PEOPLES_PAGE_INDEX
import com.demo.virginmoneydemo.adapters.ROOM_LIST_PAGE_INDEX
import com.demo.virginmoneydemo.databinding.FragmentHomeViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentHomeViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = HomePagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

//        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            PEOPLES_PAGE_INDEX -> getString(R.string.peoples)
            ROOM_LIST_PAGE_INDEX -> getString(R.string.room_list_title)
            else -> null
        }
    }
}