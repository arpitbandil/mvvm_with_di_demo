package com.demo.virginmoneydemo.ui.rooms

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.demo.virginmoneydemo.R
import com.demo.virginmoneydemo.adapters.PeopleListAdapter
import com.demo.virginmoneydemo.adapters.RoomListAdapter
import com.demo.virginmoneydemo.databinding.FragmentPeopleBinding
import com.demo.virginmoneydemo.databinding.FragmentRoomsListBinding
import com.demo.virginmoneydemo.viewmodels.PeopleViewModel
import com.demo.virginmoneydemo.viewmodels.RoomsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsListFragment : Fragment() {

    private val viewModel: RoomsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRoomsListBinding.inflate(inflater, container, false)
        val adapter = RoomListAdapter()
        binding.roomsList.adapter = adapter
        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: RoomListAdapter, binding: FragmentRoomsListBinding) {
        viewModel.roomList.observe(viewLifecycleOwner) { result ->
            binding.hasData = !result.isNullOrEmpty()
            adapter.submitList(result)
        }
    }
}