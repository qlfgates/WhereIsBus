package com.bigneardranch.android.whereisbus.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bigneardranch.android.whereisbus.data.Bus

@Database(entities = [Bus::class], version = 1, exportSchema = false)
abstract class BusDatabase : RoomDatabase(){
    abstract fun busDao(): BusDao
}