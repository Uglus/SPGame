package com.example.data.repository

import com.example.data.api.ApiHelper
import com.example.data.model.User
import com.example.spgame.domain.`interface`.UserRepository

typealias UsersListener = (users: List<User>) -> Unit

class UserRepositoryImpl (private val apiHelper: ApiHelper) : UserRepository{

    private var users : MutableList<User> = mutableListOf()
    private val listeners = mutableListOf<UsersListener>()// Всі лісенери, які прослуховють зміни
    init{
        users = apiHelper.getUsers() as MutableList<User>
    }

    override fun getUsers() = users

    override fun addUser(user:User){
        users.add(user)
        notifyChanges()
    }

    override fun deleteUser(user: User){
        val indexToDelete = users.indexOfFirst { it.id == user.id }
        if(indexToDelete != -1){
            users.removeAt(indexToDelete)
        }
        notifyChanges()
    }

    override fun addListener(listener: UsersListener){
        listeners.add(listener)
        listener.invoke(users)
    }
    override fun removeListener(listener: UsersListener){
        listeners.remove(listener)
    }

    //Щоб не повторювати одну й ту саму логіку повідомлення лісенерів
    private fun notifyChanges(){
        listeners.forEach { it.invoke(users) }
    }

}