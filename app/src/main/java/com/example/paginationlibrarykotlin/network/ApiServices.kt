package com.example.paginationlibrarykotlin.network

import com.example.paginationlibrarykotlin.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 18/02/2021
 */
interface ApiServices {
    @GET("character")
    fun getCharacters(@Query("page") page:Int):Call<MainResponse>
}