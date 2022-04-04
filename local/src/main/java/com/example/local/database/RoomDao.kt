package com.example.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.local.model.UserLocalModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface RoomDao {

    @Query("SELECT * FROM user")
    fun getUser(): Single<List<UserLocalModel>>

    @Insert
    fun insertUser(userLocalModel: UserLocalModel): Completable

    @Delete
    fun deleteUser(userLocalModel: UserLocalModel): Completable
}