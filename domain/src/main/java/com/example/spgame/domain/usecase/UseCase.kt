package com.example.spgame.domain.usecase

interface UseCase {
    suspend operator fun invoke()
}