package com.example.local.model

import androidx.room.Entity

@Entity(tableName = "user")
data class UserLocalModel(
    val name: String,
    val id: String,
    val date: String,
    val url: String
)
