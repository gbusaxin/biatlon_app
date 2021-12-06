package com.example.trainingsystem.domain.pojo


data class TeamInfo(

    val name: String? = null,

    val image: String? = null,

    val lag: String? = null,

    val result: String? = null,

    val comments: String? = null,

    val scores: Int = 0,

    val players: List<PlayerInfo>? = null

)