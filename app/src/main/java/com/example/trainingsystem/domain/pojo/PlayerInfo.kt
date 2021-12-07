package com.example.trainingsystem.domain.pojo


data class PlayerInfo(

    val player: String,

    val comment: String
): ResultUtils {
    override fun whatIs(): Int {
        return 3
    }
}