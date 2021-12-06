package com.example.trainingsystem.data.mapper

import com.example.trainingsystem.data.database.model.NewsInfoDbModel
import com.example.trainingsystem.data.network.model.NewsInfoDto
import com.example.trainingsystem.domain.pojo.NewsInfo

class NewsMapper {

    fun mapDtoToDbModel(dto:NewsInfoDto) = NewsInfoDbModel(
        head = dto.head ?: "",
        date = dto.date,
        image = dto.image,
        body = dto.body
    )

    fun mapDbModelToEntity(dbModel: NewsInfoDbModel) = NewsInfo(
        head = dbModel.head,
        date = dbModel.date,
        image = dbModel.image,
        body = dbModel.body
    )

}