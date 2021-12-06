package com.example.trainingsystem.data.network.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class NewsInfoDto(
    @SerializedName("head")
    @Expose
    val head: String? = null,

    @SerializedName("date")
    @Expose
    val date: String? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("body")
    @Expose
    val body: String? = null
)