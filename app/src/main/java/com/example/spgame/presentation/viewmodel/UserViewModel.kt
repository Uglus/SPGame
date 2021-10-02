package com.example.spgame.presentation.viewmodel

import com.example.spgame.model.User

class UserViewModel {
    var user: User? = null
    set(user){
        field = user
    }

    val name : String?
    get() = user?.name

    val img : String?
    get() = user?.img

}