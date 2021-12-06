package com.example.trainingsystem.data.network.model

import com.example.trainingsystem.domain.pojo.WorldCupRacing
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class WorldCupInfoDto (
    @SerializedName("stage")
    @Expose
    val stage: String? = null,

    @SerializedName("racing")
    @Expose
    val racing: List<WorldCupRacing>? = null
)