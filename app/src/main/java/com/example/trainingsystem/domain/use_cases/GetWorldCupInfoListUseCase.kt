package com.example.trainingsystem.domain.use_cases

import com.example.trainingsystem.domain.Repository

class GetWorldCupInfoListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getWorldCupInfoList()
}