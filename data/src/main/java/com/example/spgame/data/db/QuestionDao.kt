package com.example.spgame.data.db

import androidx.room.Dao
import androidx.room.Query
import com.example.spgame.data.model.QuestionDB

@Dao
interface QuestionDao {
    @Query("" +
            "SELECT * " +
            "FROM Questions " +
            "WHERE categoryId IS :categoryId")
    fun getAllQuestionsByCategory(categoryId:Int):List<QuestionDB>
}