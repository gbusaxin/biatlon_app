package com.example.trainingsystem.domain.use_cases

import com.example.trainingsystem.domain.Repository

class GetCandidatesInfoListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getCandidatesInfoList()
}