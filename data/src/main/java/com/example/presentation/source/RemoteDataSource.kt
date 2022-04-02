package com.example.presentation.source

import com.example.presentation.model.UserDataModel
import io.reactivex.rxjava3.core.Single

interface RemoteDataSource {
    fun getUsers(owner: String) : Single<List<UserDataModel>>
}