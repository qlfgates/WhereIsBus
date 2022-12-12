package com.bigneardranch.android.whereisbus

import android.app.Application

class BusSearchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BusRepository.initialize(this)
    }
}