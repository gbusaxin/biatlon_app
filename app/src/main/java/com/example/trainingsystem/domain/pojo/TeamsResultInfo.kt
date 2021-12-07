package com.example.trainingsystem.domain.pojo


data class TeamsResultInfo(

    val type: String,

    val condition: String,

    val date: String,

    val stage: String,

    val teams: List<TeamInfo>
): ResultUtils {
    override fun whatIs(): Int {
        return 1
    }
}
