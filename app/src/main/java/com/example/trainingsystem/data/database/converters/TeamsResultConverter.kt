package com.example.trainingsystem.data.database.converters

import androidx.room.TypeConverter
import com.example.trainingsystem.domain.pojo.TeamInfo
import com.example.trainingsystem.domain.pojo.TeamsResultInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class TeamsResultConverter {
    @TypeConverter
    fun toListFromJson(teamsResultInfo:String):List<TeamsResultInfo>{
        if(teamsResultInfo == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<TeamsResultInfo>>(){}.type
        return Gson().fromJson(teamsResultInfo,type)
    }
    @TypeConverter
    fun toJsonFromList(list:List<TeamsResultInfo>) = Gson().toJson(list)

    @TypeConverter
    fun toListFromJsonTeamInfo(teamsResultInfo:String):List<TeamInfo>{
        if(teamsResultInfo == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<TeamInfo>>(){}.type
        return Gson().fromJson(teamsResultInfo,type)
    }
    @TypeConverter
    fun toJsonFromListTeamInfo(list:List<TeamInfo>) = Gson().toJson(list)
}