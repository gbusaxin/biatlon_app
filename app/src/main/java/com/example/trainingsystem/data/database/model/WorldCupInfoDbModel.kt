package com.example.trainingsystem.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.trainingsystem.data.database.converters.WorldCupConverter
import com.example.trainingsystem.domain.pojo.WorldCupRacing

@Entity(tableName = "world_cup")
@TypeConverters(WorldCupConverter::class)
data class WorldCupInfoDbModel (
    @PrimaryKey
    val stage: String,
    val racing: List<WorldCupRacing>
)