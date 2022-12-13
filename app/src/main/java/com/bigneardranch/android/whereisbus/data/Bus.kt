package com.bigneardranch.android.whereisbus.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

// 각각의 버스(각 차량)의 정보

private const val TAG = "BUS_INFO"

@JsonClass(generateAdapter = true)
data class Bus(

    //노선ID:버스노선(2412 등) : 요청메시지에 포함
    val routeId: String,

//    val ServiceResult: String,
//    val comMsgHeader: String,
    //결과코드
//    val headerCd: String,
//    val headerMsg: String,
//    val itemCount: Int,
//    val msgBody: String,
//    val itemList: String,

    //구간순번
    val sectOrd: String,
//    val fullSectDist: Float,
//    val sectDist: Float,
//    val rtDist: Float,

    //정류소도착여부
    val stopFlag: String,
    //구간Id
    val sectionId: String,
//    val dataTm: Date,
//    val gpsX: Float,
//    val gpsY: Float,

    //버스ID
    val vehId: String,
    //차량번호
    @Json(name = "plainNo")
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