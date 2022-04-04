package com.example.presentation.source

import com.example.presentation.model.UserDataModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface LocalDataSource {
    fun getLcoalUser(): Single<List<UserDataModel>>

    fun insertUser(userDataModel: UserDataModel): Completable

    fun deleteUser(userDataModel: UserDataModel): Completable
}