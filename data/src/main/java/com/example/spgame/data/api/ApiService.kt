package com.example.spgame.data.api

import com.example.spgame.data.model.Category
import com.example.spgame.data.model.User

interface ApiService {

    fun getUsers(): List<User>
    fun getCategories() : List<Category>
}