package com.bigneardranch.android.whereisbus.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bigneardranch.android.whereisbus.Bus

@Database(entities = [Bus::class], version = 1)
abstract class BusDatabase : RoomDatabase()
