package com.example.data.api

import com.example.data.model.Category
import com.example.data.model.User

interface ApiService {

    fun getUsers(): List<User>
    fun getCategories() : List<Category>
}