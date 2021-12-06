package com.example.trainingsystem.domain.pojo


data class TeamsResultInfo(
    private val type: String? = null,

    private val condition: String? = null,

    private val date: String? = null,

    private val stage: String? = null,

    private val teams: List<TeamInfo>? = null
)