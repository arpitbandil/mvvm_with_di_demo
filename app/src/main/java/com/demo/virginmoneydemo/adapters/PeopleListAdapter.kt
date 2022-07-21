package com.demo.virginmoneydemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.demo.virginmoneydemo.R
import com.demo.virginmoneydemo.models.People
import com.demo.virginmoneydemo.databinding.ListItemPeopleBinding
import com.demo.virginmoneydemo.ui.HomeViewPagerFragmentDirections

class PeopleListAdapter : ListAdapter<People, PeopleListAdapter.ViewHolder>(PeopleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_people,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ListItemPeopleBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.people?.let {
                    navigateToPeopleDetail(it, view)
                }
            }
        }

        private fun navigateToPeopleDetail(people: People, view: View) {
            val direction = HomeViewPagerFragmentDirections
                .actionHomeViewPagerFragmentToPeopleDetailFragment(people)
            view.findNavController().navigate(direction)
        }

        fun bind(peopleItem: People) {
            with(binding) {
                people = peopleItem
                executePendingBindings()
            }
        }
    }
}

private class PeopleDiffCallback : DiffUtil.ItemCallback<People>() {

    override fun areItemsTheSame(
        oldItem: People,
        newItem: People
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: People,
        newItem: People
    ): Boolean {
        return oldItem.fullName == newItem.fullName && oldItem.jobtitle == newItem.jobtitle &&
                oldItem.avatar == newItem.avatar && oldItem.email == newItem.email &&
                oldItem.favouriteColor == newItem.favouriteColor
    }
}
