package com.example.spgame.data.repository

import androidx.room.Room
import com.example.spgame.data.api.ApiHelper
import com.example.spgame.data.db.AppDataBase
import com.example.spgame.data.db.CategoryDao
import com.example.spgame.domain.model.Category
import com.example.spgame.domain.repository.CategoryRepository

typealias CategoryListener = (categories: List<Category>) -> Unit

class CategoryRepositoryImpl (private val apiHelper: ApiHelper,
                              private var dao:CategoryDao) : CategoryRepository {
    private final val TAG : String = CategoryRepositoryImpl::class.java.name


    private var categories : MutableList<Category> = mutableListOf()

    init{
        categories = apiHelper.getCategories()  as MutableList<Category>
    }

    override fun getCategories() = categories




}