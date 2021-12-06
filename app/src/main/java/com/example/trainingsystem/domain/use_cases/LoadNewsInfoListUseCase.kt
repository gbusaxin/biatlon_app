package com.example.trainingsystem.domain.use_cases

import com.example.trainingsystem.domain.Repository

class LoadNewsInfoListUseCase(private val repository: Repository) {
    suspend operator fun invoke() = repository.loadNewsData()
}