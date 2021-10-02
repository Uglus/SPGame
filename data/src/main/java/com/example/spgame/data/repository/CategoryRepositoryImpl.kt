package com.example.spgame.data.repository

import com.example.spgame.data.api.ApiHelper
import com.example.spgame.domain.model.Category
import com.example.spgame.domain.repository.CategoryRepository

typealias CategoryListener = (categories: List<Category>) -> Unit

class CategoryRepositoryImpl (private val apiHelper: ApiHelper) : CategoryRepository {
    private final val TAG : String = CategoryRepositoryImpl::class.java.name

    private var categories : MutableList<Category> = mutableListOf()
    private val listeners = mutableListOf<CategoryListener>()

    init{
        categories = apiHelper.getCategories()  as MutableList<Category>
    }

    override fun getCategories() = categories

/*    override fun addListener(listener: CategoryListener){
        listeners.add(listener)
        listener.invoke(categories)
    }
    override fun removeListener(listener: CategoryListener){
        listeners.remove(listener)
    }*/



}