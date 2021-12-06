package com.example.trainingsystem.data.database.room_db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.trainingsystem.data.database.model.CandidatInfoDbModel
import com.example.trainingsystem.data.database.model.NewsInfoDbModel
import com.example.trainingsystem.data.database.model.WorldCupInfoDbModel

@Dao
interface DaoDb {

    @Query("SELECT * FROM news_info")
    fun getNewsInfoList(): LiveData<List<NewsInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsList(newsList: List<NewsInfoDbModel>)

    @Query("SELECT * FROM world_cup")
    fun getWorldCupInfoList(): LiveData<List<WorldCupInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorldCupList(worldCupInfo: List<WorldCupInfoDbModel>)

    @Query("SELECT * FROM candidate_info")
    fun getCandidatesInfoList(): LiveData<List<CandidatInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCandidatesList(candidates: List<CandidatInfoDbModel>)


}