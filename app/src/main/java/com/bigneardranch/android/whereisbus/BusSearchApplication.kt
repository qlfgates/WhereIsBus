package com.bigneardranch.android.whereisbus

import android.app.Application
import java.io.InputStreamReader

class BusSearchApplication : Application() {
    override fun onCreate() {
        super.onCreate()


        BusRepository.initialize(this)
    }
}