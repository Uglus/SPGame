package com.example.spgame.domain.`interface`

import com.example.spgame.domain.model.Category

interface CategoryRepository {

    fun getCategories() : MutableList<Category>
/*    fun addListener(listener: CategoryListener){}
    fun removeListener(listener: CategoryListener){}*/
}