package com.example.trainingsystem.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "candidate_info")
data class CandidatInfoDbModel(
    @PrimaryKey
    val name: String,
    val degree: String? = null,
    val birthday: String? = null,
    val place: String? = null
)