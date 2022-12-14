package com.bigneardranch.android.whereisbus.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

// 각각의 버스(각 차량)의 정보

private const val TAG = "BUS_INFO"

@JsonClass(generateAdapter = true)
@Entity
data class Bus(

    //노선ID:버스노선(2412 등) : 요청메시지에 포함
    val routeId: String? = null,

//    val ServiceResult: String,
//    val comMsgHeader: String,
    //결과코드
//    val headerCd: String,
//    val headerMsg: String,
//    val itemCount: Int,
//    val msgBody: String,
//    val itemList: String,

    //구간순번
    val sectOrd: String? = null,
//    val fullSectDist: Float,
//    val sectDist: Float,
//    val rtDist: Float,

    //정류소도착여부
    val stopFlag: String? = null,
    //구간Id
    val sectionId: String? = null,
//    val dataTm: Date,
//    val gpsX: Float,
//    val gpsY: Float,

    //버스ID
    val vehId: String? = null,
    //차량번호
    @Json(name = "plainNo")
    @PrimaryKey
    val plainNo: String

//    val busType: Int,
//    val lastStTm: Float,
//    val nextStTm: Float,
//    val isrunyn: Int,
//    val trnstnid: String,
//    val islastyn: Boolean,
//    val isFullFlag: Boolean,
//    val posX: Float,
//    val posY: Float,
)