package com.bigneardranch.android.whereisbus

import android.app.Application

class BusSearchResultApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BusSearchResultRepository.initialize(this)
    }
}