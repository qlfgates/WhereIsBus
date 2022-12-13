package com.bigneardranch.android.whereisbus

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigneardranch.android.whereisbus.data.Bus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "BusSearchResultViewModel"

class BusSearchResultViewModel : ViewModel() {

    private val busSearchResultRepository = BusSearchResultRepository()

    private val _busItems: MutableStateFlow<List<Bus>> = MutableStateFlow(emptyList())
    val busItems: StateFlow<List<Bus>>
        get() = _busItems.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val buses = busSearchResultRepository.fetchBuses()
                Log.d(TAG, "Buses received: $buses")
            } catch (ex: Exception){
                Log.e(TAG, "Failed to fetch bus items", ex)
            }
        }
    }

    suspend fun loadBuses(): List<Bus>{
        val buses = mutableListOf<Bus>()
        return buses
    }
}