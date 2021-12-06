package com.example.trainingsystem.data.mapper

import com.example.trainingsystem.data.database.model.CandidatInfoDbModel
import com.example.trainingsystem.data.network.model.CandidatInfoDto
import com.example.trainingsystem.domain.pojo.CandidatInfo

class CandidatMapper {

    fun mapDbModelToEntity(dbModel: CandidatInfoDbModel) = CandidatInfo(
        name = dbModel.name,
        degree = dbModel.degree,
        birthday = dbModel.birthday,
        place = dbModel.place
    )

    fun mapDtoToDbModel(dto: CandidatInfoDto) = CandidatInfoDbModel(
        name = dto.name ?: "",
        degree = dto.degree,
        birthday = dto.birthday,
        place = dto.place
    )
}