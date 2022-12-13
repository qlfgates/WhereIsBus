package com.bigneardranch.android.whereisbus

import androidx.recyclerview.widget.RecyclerView
import com.bigneardranch.android.whereisbus.data.Bus
import com.bigneardranch.android.whereisbus.databinding.ListBusDetailBinding

class BusSearchResultViewHolder(private val binding: ListBusDetailBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(bus: Bus){
        binding.busDetail.context
    }
}

class BusSearchResultListAdapter {
}