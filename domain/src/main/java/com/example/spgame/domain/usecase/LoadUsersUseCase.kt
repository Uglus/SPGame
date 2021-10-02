package com.example.spgame.domain.usecase

import com.example.spgame.domain.model.User
import com.example.spgame.domain.repository.UserRepository

class LoadUsersUseCase(private val userRepository: UserRepository)  {
    operator fun invoke() : MutableList<User> {
        return userRepository.getUsers()
    }
}