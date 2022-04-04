package com.example.local.source

import com.example.local.database.RoomDao
import com.example.presentation.model.UserDataModel
import com.example.presentation.source.LocalDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class LocalDataSourceImpl(val dao: RoomDao) : LocalDataSource {
    override fun getLcoalUser(): Single<List<UserDataModel>> {
        TODO("Not yet implemented")
    }

    override fun insertUser(userDataModel: UserDataModel): Completable {
        TODO("Not yet implemented")
    }

    override fun deleteUser(userDataModel: UserDataModel): Completable {
        TODO("Not yet implemented")
    }
}