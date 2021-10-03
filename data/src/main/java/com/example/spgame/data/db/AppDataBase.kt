package com.example.spgame.data.db

//import androidx.room.Database

import androidx.room.Database
import com.example.spgame.data.model.CategoryDB
import androidx.room.RoomDatabase
import com.example.spgame.data.model.QuestionDB

@Database(entities = arrayOf(CategoryDB::class, QuestionDB::class), version = 1)
public abstract class AppDataBase : RoomDatabase() {
    public abstract fun getQuestionDao():QuestionDao
    abstract fun getCategories():CategoryDao
}