package com.demo.virginmoneydemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.demo.virginmoneydemo.R
import com.demo.virginmoneydemo.models.Room
import com.demo.virginmoneydemo.databinding.ListItemRoomBinding
import com.demo.virginmoneydemo.ui.HomeViewPagerFragmentDirections

class RoomListAdapter : ListAdapter<Room, RoomListAdapter.ViewHolder>(RoomDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_room,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ListItemRoomBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(roomItem: Room) {
            with(binding) {
                room = roomItem
                executePendingBindings()
            }
        }
    }
}

private class RoomDiffCallback : DiffUtil.ItemCallback<Room>() {

    override fun areItemsTheSame(
        oldItem: Room,
        newItem: Room
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Room,
        newItem: Room
    ): Boolean {
        return oldItem.isOccupied == newItem.isOccupied
    }
}
