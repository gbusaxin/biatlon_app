package com.example.trainingsystem.domain.pojo


data class TeamInfo(

    val name: String,

    val image: String,

    val lag: String,

    val result: String,

    val comments: String,

    val scores: Int = 0,

    val players: List<PlayerInfo>

) : ResultUtils {
    override fun whatIs(): Int {
        return 2
    }
}