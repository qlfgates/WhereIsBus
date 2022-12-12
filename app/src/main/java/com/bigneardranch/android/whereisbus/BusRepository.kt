package com.bigneardranch.android.whereisbus

import android.content.Context
import androidx.room.Room
import com.bigneardranch.android.whereisbus.database.BusDatabase

private const val DATABASE_NAME = "bus-database"

class BusRepository private constructor(context: Context){

    private val database: BusDatabase = Room.databaseBuilder(
        context.applicationContext,
        BusDatabase::class.java,
        DATABASE_NAME).build()


    companion object{
        private var INSTANCE: BusRepository? = null

        fun initialize(context: Context){
            if (INSTANCE == null){
                INSTANCE = BusRepository(context)
            }
        }

        fun get(): BusRepository{
            return INSTANCE ?: throw IllegalStateException("BusRepository must be initialized")
        }
    }
}