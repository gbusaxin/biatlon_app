package com.example.trainingsystem.data.network.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class CandidatInfoDto(
    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("degree")
    @Expose
    val degree: String? = null,

    @SerializedName("birthday")
    @Expose
    val birthday: String? = null,

    @SerializedName("place")
    @Expose
    val place: String? = null
)