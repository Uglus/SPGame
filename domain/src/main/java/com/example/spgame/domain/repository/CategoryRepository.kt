package com.example.spgame.domain.repository

import com.example.spgame.domain.model.Category

interface CategoryRepository {

    fun getCategories() : MutableList<Category>

}