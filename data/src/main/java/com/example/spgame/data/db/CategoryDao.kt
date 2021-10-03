package com.example.spgame.data.db

import androidx.room.Dao
import androidx.room.Query
import com.example.spgame.data.model.CategoryDB

@Dao
interface CategoryDao {
    @Query("SELECT * " +
            "FROM Categories")
    fun getAllCategories(): List<CategoryDB>
}