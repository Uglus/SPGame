package com.example.data.api

import android.util.Log
import com.example.data.model.Category

class ApiHelper(private val apiService: ApiService) {
    private final val TAG : String = ApiHelper::class.java.name

    fun getUsers() = apiService.getUsers()

    fun getCategories() : List<Category> {
        val categories = apiService.getCategories() as MutableList<Category>
        /*categories.apply {
            add(0,categories[categories.size-1])
            add(0,categories[categories.size-2])
            add(categories.size-1,categories[0])
            add(categories.size-1,categories[1])
        }*/
        Log.d(TAG,"Отримана кількість категорій: ${categories.size}")
        return categories

    }
}