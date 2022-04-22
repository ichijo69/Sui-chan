package com.ichijo.suichan

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SuichanBrainInterface {


    @GET("/get?bid=155777&key=O0Rla6COZJ8XSGPJ&uid=nothing")
    fun getMessage(@Query("msg") msg: String):Call<Suichan>?

    companion object {

        var BASE_URL = "http://api.brainshop.ai/"

        fun create() : SuichanBrainInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(SuichanBrainInterface::class.java)

        }
    }
}