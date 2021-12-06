package com.example.trainingsystem.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_info")
class NewsInfoDbModel (

    @PrimaryKey
    val head: String,

    val date: String? = null,

    val image: String? = null,

    val body: String? = null

)
