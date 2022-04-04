package com.example.local.source

import com.example.common.mapper.Mapper
import com.example.local.database.RoomDao
import com.example.local.model.UserLocalModel
import com.example.presentation.model.UserDataModel
import com.example.presentation.source.LocalDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dao: RoomDao,
    private val mapper: Mapper<UserLocalModel, UserDataModel>
) : LocalDataSource {
    override fun getLcoalUser(): Single<List<UserDataModel>> {
        return dao.getUser().map {
            it.map {
                mapper.from(it)
            }
        }
    }

    // mapper의 방향이 이게 맞남? (from / to )

    override fun insertUser(userDataModel: UserDataModel): Completable {
        return dao.insertUser(mapper.to(userDataModel))
    }

    override fun deleteUser(userDataModel: UserDataModel): Completable {
        return dao.deleteUser(mapper.to(userDataModel))
    }
}