package com.example.trainingsystem.data.mapper

import com.example.trainingsystem.data.database.model.WorldCupInfoDbModel
import com.example.trainingsystem.data.network.model.WorldCupInfoDto
import com.example.trainingsystem.domain.pojo.WorldCupInfo

class WorldCupMapper {
    fun mapDtoToDbModel(dto:WorldCupInfoDto) = WorldCupInfoDbModel(
        stage = dto.stage ?:"",
        racing = dto.racing ?: listOf()
    )

    fun mapDbModelToEntity(dbModel: WorldCupInfoDbModel) = WorldCupInfo(
        stage = dbModel.stage,
        racing = dbModel.racing
    )
}