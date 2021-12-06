package com.example.trainingsystem.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingsystem.data.repository.RepositoryImpl
import com.example.trainingsystem.domain.use_cases.*
import kotlinx.coroutines.launch

class AppViewModel(application: Application):AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)

    private val getNewsInfoListUseCase = GetNewsInfoListUseCase(repository)
    private val getWorldCupInfoListUseCase = GetWorldCupInfoListUseCase(repository)
    private val getCandidatesInfoListUseCase = GetCandidatesInfoListUseCase(repository)

    private val loadNewsInfoListUseCase = LoadNewsInfoListUseCase(repository)
    private val loadWorldCupInfoListUseCase = LoadWorldCupInfoListUseCase(repository)
    private val loadCandidatesInfoListUseCase = LoadCandidatesInfoListUseCase(repository)

    val newsInfoList = getNewsInfoListUseCase()
    val worldCupList = getWorldCupInfoListUseCase()
    val candidatesList = getCandidatesInfoListUseCase()

    init {
        viewModelScope.launch {
            loadNewsInfoListUseCase()
            loadWorldCupInfoListUseCase()
            loadCandidatesInfoListUseCase()
        }
    }
}