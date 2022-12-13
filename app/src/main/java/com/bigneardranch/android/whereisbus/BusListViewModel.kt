package com.bigneardranch.android.whereisbus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigneardranch.android.whereisbus.data.Bus
import com.opencsv.CSVReader
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.InputStreamReader


class BusListViewModel(private var routId: String) : ViewModel() {

    val buses = mutableListOf<Bus>()


    init{
        viewModelScope.launch {
            delay(5000)
            for (i in 0 until 500 ){
                val bus = Bus(
                    routeId = routId,
                    sectOrd = "",
                    stopFlag = "",
                    sectionId = "",
                    vehId = "",
                    plainNo = ""
                )
                buses += bus
            }
            buses += loadBuses()
        }
    }

    suspend fun loadBuses() : List<Bus>{
        val result = mutableListOf<Bus>()
        delay(5000)
        for (i in 0 until 500 ){
            val bus = Bus(
                routeId = "",
                sectOrd = "",
                stopFlag = "",
                sectionId = "",
                vehId = "",
                plainNo = ""
            )
            result += bus
        }
        return result
    }
}