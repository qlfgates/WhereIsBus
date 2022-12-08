package com.bigneardranch.android.whereisbus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bigneardranch.android.whereisbus.databinding.ListBusDetailBinding


class BusResultViewHolder(val binding: ListBusDetailBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(bus: Bus){
        binding.routeId.text = bus.routeId
        binding.vehId.text = bus.vehId

        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${bus.routeId} clicked", Toast.LENGTH_SHORT).show()
        }
        binding.busStopIcon.visibility = if(bus.stopFlag!=null){
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}

class BusListAdapter(private val buses: List<Bus>) : RecyclerView.Adapter<BusResultViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListBusDetailBinding.inflate(inflater, parent, false)
        return BusResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BusResultViewHolder, position: Int) {
        val bus = buses[position]
        holder.apply {
            binding.vehId.text = bus.routeId
            binding.routeId.text = bus.vehId
        }
    }

    override fun getItemCount() = buses.size
}