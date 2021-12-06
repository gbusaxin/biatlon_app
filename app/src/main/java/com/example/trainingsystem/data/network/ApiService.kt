package com.example.trainingsystem.data.network

import com.example.trainingsystem.data.network.model.CandidatInfoDto
import com.example.trainingsystem.data.network.model.NewsInfoDto
import com.example.trainingsystem.data.network.model.TeamsResultInfoDto
import com.example.trainingsystem.data.network.model.WorldCupInfoDto
import retrofit2.http.GET

interface ApiService {

    @GET("news_biatlon.json")
    suspend fun loadNewsList():List<NewsInfoDto>

    @GET("world_cup.json")
    suspend fun loadWorldCupList():List<WorldCupInfoDto>

    @GET("russian_candidates.json")
    suspend fun loadCandidatesList():List<CandidatInfoDto>

    @GET("teams_result.json")
    suspend fun loadTeamsResultList():List<TeamsResultInfoDto>

}