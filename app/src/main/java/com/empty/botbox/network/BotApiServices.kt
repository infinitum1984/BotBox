package com.empty.botbox.network

import android.database.Observable
import com.empty.botbox.models.BotResponse
import retrofit2.http.GET

interface BotApiServices {
    @GET("pokemon")
    fun getBots():Observable<BotResponse>
}