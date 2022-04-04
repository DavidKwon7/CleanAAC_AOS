package com.example.domain.repository

import com.example.domain.entity.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getUsers(owner: String) : Single<List<User>>

    fun getLcoalUser(): Single<List<User>>

    fun insertUser(userDataModel: User): Completable

    fun deleteUser(userDataModel: User): Completable
}