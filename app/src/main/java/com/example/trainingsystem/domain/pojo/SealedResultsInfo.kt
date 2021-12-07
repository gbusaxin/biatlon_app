package com.example.trainingsystem.domain.pojo

sealed class SealedResultsInfo{

    //fun mapEntityToSealed(entity:)

    class Result(
        val type: String,

        val condition: String,

        val date: String,

        val stage: String,

        val teams: List<TeamInfo>
    ):SealedResultsInfo()

    class Coutry(
        val name: String,

        val image: String,

        val lag: String,

        val result: String,

        val comments: String,

        val scores: Int = 0,

        val players: List<PlayerInfo>
    ):SealedResultsInfo()

    class Team(
        val player: String,

        val comment: String
    ):SealedResultsInfo()
}
