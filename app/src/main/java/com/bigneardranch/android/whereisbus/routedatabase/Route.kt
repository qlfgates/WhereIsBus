package com.bigneardranch.android.whereisbus.routedatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Route(
    val busNumber: String,
    @PrimaryKey val busId: String
)