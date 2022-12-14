package com.bigneardranch.android.whereisbus

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigneardranch.android.whereisbus.data.Bus
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private const val TAG = "BusListViewModel"

class BusListViewModel() : ViewModel() {

    private val busRepository = BusRepository.get()

    private val _buses: MutableStateFlow<List<Bus>> = MutableStateFlow(emptyList())
    val buses: StateFlow<List<Bus>>
        get() = _buses.asStateFlow()

    init{
        Log.d(TAG, "BusLineViewModel Init.....")
        viewModelScope.launch {
            busRepository.getBuses().collect(){
                _buses.value = it
            }
        }
    }

    fun init() {
        Log.d(TAG, "BusLineViewModel Init.....")
        viewModelScope.launch {
            busRepository.getBuses().collect(){
                _buses.value = it
            }
        }

    }

//    suspend fun addBus(bus: Bus){
//        busRepository.addBus(bus)
//    }
}