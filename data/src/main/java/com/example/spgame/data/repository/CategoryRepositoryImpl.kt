package com.example.data.repository

import android.util.Log
import com.example.data.api.ApiHelper
import com.example.data.model.Category
import com.example.spgame.domain.`interface`.CategoryRepository

typealias CategoryListener = (categories: List<Category>) -> Unit

class CategoryRepositoryImpl (private val apiHelper: ApiHelper) : CategoryRepository {
    private final val TAG : String = CategoryRepositoryImpl::class.java.name

    private var categories : MutableList<Category> = mutableListOf()
    private val listeners = mutableListOf<CategoryListener>()

    init{
        categories = apiHelper.getCategories()  as MutableList<Category>
        Log.d(TAG, "Initialized. Count of received categories: ${categories.size}")
    }

    override fun getCategories() = categories

    override fun addListener(listener: CategoryListener){
        listeners.add(listener)
        listener.invoke(categories)
    }
    override fun removeListener(listener: CategoryListener){
        listeners.remove(listener)
    }



}