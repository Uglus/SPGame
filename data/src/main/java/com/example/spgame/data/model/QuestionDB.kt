package com.example.spgame.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Questions")
/*    foreignKeys = [ForeignKey(
    entity = CategoryDB::class,
    parentColumns = ["id"],
    childColumns = ["categoryId"])])*/
data class QuestionDB (
    @PrimaryKey
    val id:Int,
    val categoryId:Int,
    val title:String,
    val answer:Boolean
    )