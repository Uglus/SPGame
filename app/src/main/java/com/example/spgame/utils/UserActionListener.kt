package com.example.spgame.utils

import com.example.spgame.model.User

interface UserActionListener {
    fun onUserRemove(user: User)
}