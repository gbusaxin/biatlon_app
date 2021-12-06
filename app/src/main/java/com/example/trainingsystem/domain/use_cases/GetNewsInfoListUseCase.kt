package com.example.trainingsystem.domain.use_cases

import com.example.trainingsystem.domain.Repository

class GetNewsInfoListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getNewsInfoList()
}