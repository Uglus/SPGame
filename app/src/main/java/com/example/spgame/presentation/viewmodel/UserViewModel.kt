package com.example.spgame.ui.main.viewmodel

import com.example.spgame.data.model.User

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