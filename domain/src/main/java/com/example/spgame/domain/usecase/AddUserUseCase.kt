package com.example.spgame.domain.usecase

import com.example.spgame.domain.repository.UserRepository

class AddUserUseCase(private val userRepository : UserRepository) : UseCase {
    override suspend operator fun invoke() {
        TODO("Not yet implemented")
    }
}