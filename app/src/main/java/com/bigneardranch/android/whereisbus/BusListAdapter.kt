package com.bigneardranch.android.whereisbus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bigneardranch.android.whereisbus.databinding.ListBusDetailBinding
import com.bigneardranch.android.whereisbus.routedatabase.Route


class BusViewHolder(private val binding: ListBusDetailBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(route: Route, onRouteClicked: (busId: String) -> Unit){
        binding.routeId.text = route.busNumber
        binding.vehId.text = route.busId

        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "BusNumber: ${route.busNumber} clicked", Toast.LENGTH_SHORT).show()
            onRouteClicked(route.busId)
        }
    }
}

class BusListAdapter(
    private val routes: List<Route>,
    private val onRouteClicked: (routeId: String) -> Unit)
    : RecyclerView.Adapter<BusViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListBusDetailBinding.inflate(inflater, parent, false)
        return BusViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BusViewHolder, position: Int) {
        val route = routes[position]
        holder.bind(route, onRouteClicked)
//        holder.apply {
//            binding.routeId.text = route.busNumber
//            binding.vehId.text = route.busId
//        }
    }

    override fun getItemCount() = routes.size
}