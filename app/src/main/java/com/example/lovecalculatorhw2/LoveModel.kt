package com.example.lovecalculatorhw2

import com.google.gson.annotations.SerializedName


data class LoveModel(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String
) : java.io.Serializable