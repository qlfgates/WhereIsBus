package com.bigneardranch.android.whereisbus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bigneardranch.android.whereisbus.data.Bus
import com.bigneardranch.android.whereisbus.databinding.ListBusDetailBinding

class BusDetailViewHolder(val binding: ListBusDetailBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(bus: Bus){

        binding.busStopIcon.visibility = View.VISIBLE
    }
}


class BusDetailAdapter(private val buses: List<Bus>) : RecyclerView.Adapter<BusDetailViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListBusDetailBinding.inflate(inflater, parent, false)
        return BusDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BusDetailViewHolder, position: Int) {
//        val bus = buses[position]
//        holder.bind(bus)

    }

    override fun getItemCount() = 1

}