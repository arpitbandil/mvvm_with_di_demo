package com.demo.virginmoneydemo.ui.people

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.demo.virginmoneydemo.adapters.PeopleListAdapter
import com.demo.virginmoneydemo.databinding.FragmentPeopleBinding
import com.demo.virginmoneydemo.viewmodels.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private val viewModel: PeopleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPeopleBinding.inflate(inflater, container, false)
        val adapter = PeopleListAdapter()
        binding.peopleList.adapter = adapter
        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: PeopleListAdapter, binding: FragmentPeopleBinding) {
        viewModel.peopleList.observe(viewLifecycleOwner) { result ->
            binding.hasData = !result.isNullOrEmpty()
            adapter.submitList(result)
        }
    }
}