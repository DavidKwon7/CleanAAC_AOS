package com.example.remote.source

import com.example.common.mapper.Mapper
import com.example.presentation.model.UserDataModel
import com.example.presentation.source.RemoteDataSource
import com.example.remote.api.ApiService
import com.example.remote.model.UserRemoteModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * mapper 를 통한 data 간의 연결
 */

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val userMapper : Mapper<UserRemoteModel, UserDataModel>
) : RemoteDataSource {

    // remote -> data
    override fun getUsers(owner: String): Single<List<UserDataModel>> {
        return apiService.getRepos(owner).map {
            it.map { userRemoteModel -> userMapper.from(userRemoteModel) }
        }
    }
}