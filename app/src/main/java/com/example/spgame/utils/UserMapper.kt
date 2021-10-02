package com.example.spgame.utils

import com.example.spgame.domain.model.User

class UserMapper {

    companion object{
        fun mapDomainUserToAppUser(user: User) : com.example.spgame.model.User{
            return com.example.spgame.model.User(
                id = user.id,
                name = user.name,
                img = user.img
            )
        }

        fun mapDomainUsersToAppUsers(users : List<User>):List<com.example.spgame.model.User>{
            val appUsers = mutableListOf<com.example.spgame.model.User>()
            users.forEach {
                appUsers.add(mapDomainUserToAppUser(it))
            }
            return appUsers
        }

    }

}