package com.bigneardranch.android.whereisbus

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

private const val TAG = "BusSearchResultViewModel"

// 찾은 결과

class BusSearchResultViewModel : ViewModel() {

    val buses = mutableListOf<Bus>()

    init {
        for (i in 0 until 10){
            val bus = Bus(
                selectOrd = "101010",
                stopFlag = "1",
                selectId = "111",
                vehId = "1024",
                plainNo = "46구4566",
                routeId = "1212")
            buses += bus
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