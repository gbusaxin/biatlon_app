package com.example.trainingsystem.data.network.model

import com.example.trainingsystem.domain.pojo.TeamInfo
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class TeamsResultInfoDto (
    @SerializedName("type")
    @Expose
     val type: String? = null,

    @SerializedName("condition")
    @Expose
     val condition: String? = null,

    @SerializedName("date")
    @Expose
     val date: String? = null,

    @SerializedName("stage")
    @Expose
     val stage: String? = null,

    @SerializedName("teams")
    @Expose
     val teams: List<TeamInfo>? = null
)