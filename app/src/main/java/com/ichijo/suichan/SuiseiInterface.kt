package com.ichijo.suichan

import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query


interface SuiseiInterface {
    @GET("/get?bid=155777&key=O0Rla6COZJ8XSGPJ&uid=nothing&msg={msg}")
    fun getMessage(@Query("msg") msg: String?, cb: Callback<String?>?)
}