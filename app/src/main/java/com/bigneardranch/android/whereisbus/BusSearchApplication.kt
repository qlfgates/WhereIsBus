package com.bigneardranch.android.whereisbus

import android.app.Application
import com.opencsv.CSVReader
import java.io.InputStreamReader

class BusSearchApplication : Application() {
    override fun onCreate() {
        super.onCreate()

//        val assetManager = this.assets
//        val inputStream = assetManager.open("bus-database.csv")
//        val reader = CSVReader(InputStreamReader(inputStream))

        BusRepository.initialize(this)


    }
}