package com.example.presentation.source

import com.example.presentation.model.UserDataModel
import io.reactivex.rxjava3.core.Single

interface LocalDataSource {
    fun getUsers() : Single<List<UserDataModel>>
}