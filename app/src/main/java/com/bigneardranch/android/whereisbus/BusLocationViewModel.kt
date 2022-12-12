package com.bigneardranch.android.whereisbus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TAG = "BusLocationViewModel"

class BusLocationViewModel : ViewModel() {

    val buses = mutableListOf<Bus>()

    init {
        viewModelScope.launch {
            delay(3000)
            for(i in 0 until 100){
                val bus = Bus(
                    selectOrd = "",
                    stopFlag = "" ,
                    selectId = "",
                    vehId = "",
                    plainNo = "",
                    routeId = ""
                )
                buses += bus
            }
            buses += loadBuses()
        }
    }
    suspend fun loadBuses() : List<Bus> {
        val result = mutableListOf<Bus>()
        delay(5000)

        for(i in 0 until 100){
            val bus = Bus(
                selectOrd = "",
                stopFlag = "" ,
                selectId = "",
                vehId = "",
                plainNo = "",
                routeId = ""
            )
            buses += bus
        }
        return result
    }


}