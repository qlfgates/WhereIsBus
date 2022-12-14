package com.bigneardranch.android.whereisbus.routedatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Route::class], version = 1)
abstract class RouteDatabase : RoomDatabase() {
    abstract fun routeDao(): RouteDao
}