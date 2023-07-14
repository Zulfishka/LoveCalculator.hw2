package com.example.lovecalculatorhw2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") fname: String,
        @Query("sname") sname: String,
        @Header("X-RapidAPI-Key") key: String = "78bb8ecc8dmsha71f7db1db6c66cp1338f5jsn2ae3a25d70d2",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}
