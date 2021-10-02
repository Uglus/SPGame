package com.example.spgame.data.api

import com.example.spgame.domain.model.Category


class ApiHelper(private val apiService: ApiService) {
    fun getUsers() = apiService.getUsers()

    fun getCategories(): List<Category> {
        val categoriesData = apiService.getCategories() as MutableList<com.example.spgame.data.model.Category>
        val categoriesDomain : MutableList<Category> = mutableListOf()
        categoriesData.forEach {
            categoriesDomain.add(Category(
                id = it.id,
                name = it.name,
                image = it.image
            ))
        }
        return categoriesDomain
    }
}