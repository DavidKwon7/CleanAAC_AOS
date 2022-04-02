package com.example.presentation.repository

import com.example.common.mapper.Mapper
import com.example.domain.entity.User
import com.example.domain.repository.Repository
import com.example.presentation.model.UserDataModel
import com.example.presentation.source.RemoteDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val userMapper : Mapper<UserDataModel, User>
) : Repository {
    override fun getUsers(owner: String): Single<List<User>> {
        return remoteDataSource.getUsers(owner).map {
            it.map {
                userMapper.from(it)     // data -> domain
            }
        }
    }
}