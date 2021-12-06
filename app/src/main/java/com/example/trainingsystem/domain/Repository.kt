package com.example.trainingsystem.domain

import androidx.lifecycle.LiveData
import com.example.trainingsystem.domain.pojo.CandidatInfo
import com.example.trainingsystem.domain.pojo.NewsInfo
import com.example.trainingsystem.domain.pojo.TeamsResultInfo
import com.example.trainingsystem.domain.pojo.WorldCupInfo

interface Repository {

    fun getTeamsResultInfoList():LiveData<List<TeamsResultInfo>>

    fun getNewsInfoList():LiveData<List<NewsInfo>>

    fun getWorldCupInfoList():LiveData<List<WorldCupInfo>>

    fun getCandidatesInfoList():LiveData<List<CandidatInfo>>

    suspend fun loadCandidatesData()

    suspend fun loadWorldCupData()

    suspend fun loadNewsData()

    suspend fun loadTeamsResultData()
}