package com.example.trainingsystem.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.trainingsystem.data.database.room_db.AppDatabase
import com.example.trainingsystem.data.mapper.CandidatMapper
import com.example.trainingsystem.data.mapper.NewsMapper
import com.example.trainingsystem.data.mapper.ResultMapper
import com.example.trainingsystem.data.mapper.WorldCupMapper
import com.example.trainingsystem.data.network.ApiFactory
import com.example.trainingsystem.domain.Repository
import com.example.trainingsystem.domain.pojo.CandidatInfo
import com.example.trainingsystem.domain.pojo.NewsInfo
import com.example.trainingsystem.domain.pojo.TeamsResultInfo
import com.example.trainingsystem.domain.pojo.WorldCupInfo

class RepositoryImpl(private val application: Application) : Repository {

    private val dao = AppDatabase.getInstance(application).getDao()
    private val apiService = ApiFactory.apiService
    private val newsMapper = NewsMapper()
    private val worldCupMapper = WorldCupMapper()
    private val candidatMapper = CandidatMapper()
    private val resultMapper = ResultMapper()

    override fun getTeamsResultInfoList(): LiveData<List<TeamsResultInfo>> {
        return Transformations.map(dao.getTeamsResultInfoList()) {
            it.map { resultMapper.mapDbModelToEntity(it) }
        }
    }

    override fun getNewsInfoList(): LiveData<List<NewsInfo>> {
        return Transformations.map(dao.getNewsInfoList()) {
            it.map { newsMapper.mapDbModelToEntity(it) }
        }
    }

    override fun getWorldCupInfoList(): LiveData<List<WorldCupInfo>> {
        return Transformations.map(dao.getWorldCupInfoList()) {
            it.map { worldCupMapper.mapDbModelToEntity(it) }
        }
    }

    override fun getCandidatesInfoList(): LiveData<List<CandidatInfo>> {
        return Transformations.map(dao.getCandidatesInfoList()) {
            it.map { candidatMapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadCandidatesData() {
        try {
            val dto = apiService.loadCandidatesList()
            val dbModel = dto.map { candidatMapper.mapDtoToDbModel(it) }
            dao.insertCandidatesList(dbModel)
        } catch (e: Exception) {
        }
    }

    override suspend fun loadWorldCupData() {
        try {
            val worldCupDto = apiService.loadWorldCupList()
            val worldCupDbModel = worldCupDto.map { worldCupMapper.mapDtoToDbModel(it) }
            dao.insertWorldCupList(worldCupDbModel)
        } catch (e: Exception) {
        }
    }

    override suspend fun loadNewsData() {
        try {
            val newsInfoDto = apiService.loadNewsList()
            val newsDbModel = newsInfoDto.map { newsMapper.mapDtoToDbModel(it) }
            dao.insertNewsList(newsDbModel)
        } catch (e: Exception) {
        }
    }

    override suspend fun loadTeamsResultData() {
        try {
            val dto = apiService.loadTeamsResultList()
            val dbModel = dto.map { resultMapper.mapDtoToDbModel(it) }
            dao.insertTeamsResultList(dbModel)
        } catch (e: Exception) {
        }
    }
}