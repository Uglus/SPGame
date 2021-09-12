package com.example.spgame.domain.`interface`

import com.example.spgame.domain.model.User


interface UserRepository {
    fun getUsers() : MutableList<User>
    fun addUser(user:User)
    fun deleteUser(user:User)
/*    fun addListener(listener: UsersListener)
    fun removeListener(listener: UsersListener)*/
}