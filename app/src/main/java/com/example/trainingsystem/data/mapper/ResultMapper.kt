package com.example.trainingsystem.data.mapper

import com.example.trainingsystem.data.database.model.TeamsResultInfoDbModel
import com.example.trainingsystem.data.network.model.TeamsResultInfoDto
import com.example.trainingsystem.domain.pojo.TeamsResultInfo
import java.util.*

class ResultMapper {

    fun mapDbModelToEntity(dbModel: TeamsResultInfoDbModel) = TeamsResultInfo(
        type = dbModel.type,
        condition = dbModel.condition?:"",
        date = dbModel.date?:"",
        stage = dbModel.stage?:"",
        teams = dbModel.teams?:Collections.emptyList()
    )

    fun mapDtoToDbModel(dto: TeamsResultInfoDto) = TeamsResultInfoDbModel(
        type = dto.type ?: "",
        condition = dto.condition,
        date = dto.date,
        stage = dto.stage,
        teams = dto.teams
    )
}