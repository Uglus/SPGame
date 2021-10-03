package com.example.spgame.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryDB (
    @PrimaryKey
    val id:Int,
    val name:String
)
