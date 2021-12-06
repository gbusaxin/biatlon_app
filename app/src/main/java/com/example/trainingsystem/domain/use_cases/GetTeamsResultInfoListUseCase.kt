package com.example.trainingsystem.domain.use_cases

import com.example.trainingsystem.domain.Repository

class GetTeamsResultInfoListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getTeamsResultInfoList()
}