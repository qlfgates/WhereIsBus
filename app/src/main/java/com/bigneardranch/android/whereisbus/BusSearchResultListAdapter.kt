package com.bigneardranch.android.whereisbus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bigneardranch.android.whereisbus.data.Bus
import com.bigneardranch.android.whereisbus.databinding.ListBusStopBinding


class BusSearchResultListHolder(val binding: ListBusStopBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(bus: Bus){
        binding.busstopName.text = bus.sectionId
        binding.busstopId.text = bus.sectOrd

        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${bus.sectionId} clicked", Toast.LENGTH_SHORT).show()
        }
        binding.busStopIcon.visibility = if(bus.stopFlag!=null){
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}

class BusSearchResultListAdapter(private val buses: List<Bus>) : RecyclerView.Adapter<BusSearchResultListHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusSearchResultListHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ListBusStopBinding.inflate(inflater, parent, false)
        return BusSearchResultListHolder(binding)
    }

    override fun onBindViewHolder(holder: BusSearchResultListHolder, position: Int) {
        val bus = buses[position]
        holder.apply {
            binding.busstopName.text = bus.sectionId
            binding.busstopId.text = bus.sectOrd
        }
        holder.bind(bus)
    }

    override fun getItemCount() = buses.size
}