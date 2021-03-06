package com.example.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.local.model.UserLocalModel

@Database(
    entities = [UserLocalModel::class],
    version = 1,
    exportSchema = false
)
abstract class RoomDB : RoomDatabase() {
    abstract fun roomDao() : RoomDao
}