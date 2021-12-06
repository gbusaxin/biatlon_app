package com.example.trainingsystem.data.database.converters

import androidx.room.TypeConverter
import com.example.trainingsystem.domain.pojo.WorldCupRacing
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class WorldCupConverter {
    @TypeConverter
    fun toListFromJson(worldCupRacing:String):List<WorldCupRacing>{
        if(worldCupRacing == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<WorldCupRacing>>(){}.type
        return Gson().fromJson(worldCupRacing,type)
    }
    @TypeConverter
    fun toJsonFromList(list:List<WorldCupRacing>) = Gson().toJson(list)
}