package com.example.trainingsystem.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.trainingsystem.data.database.converters.TeamsResultConverter
import com.example.trainingsystem.domain.pojo.TeamInfo

@Entity(tableName = "result_list")
@TypeConverters(TeamsResultConverter::class)
data class TeamsResultInfoDbModel (

    @PrimaryKey
    val type: String ,

    val condition: String? = null,

    val date: String? = null,

    val stage: String? = null,

    val teams: List<TeamInfo>? = null
)