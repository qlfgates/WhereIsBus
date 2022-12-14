package com.bigneardranch.android.whereisbus.api

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


//"getBusPosByRtid?" + "ServiceKey=$API_KEY" + "&busRouteId=100100118" + "resultType=json"

private const val API_KEY = "zH5Ha%2BqqrVSIOJ8Sq9nKTBxPEwVzbrapRS2OEzmyEcDi0y6EtEjOrrWMRHfOmOkyhXp8Jb9zMeGgpT8YHc0pAw%3D%3D"

class BusLocationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest: Request = chain.request()

        val newUrl: HttpUrl = originalRequest.url.newBuilder()
            .addQueryParameter("ServiceKey", API_KEY)
            .addQueryParameter("busRouteId", "100100118")
            .addQueryParameter("resultType", "json")
            .build()

        val newRequest: Request = originalRequest.newBuilder().url(newUrl).build()

        return chain.proceed(newRequest)
    }
}