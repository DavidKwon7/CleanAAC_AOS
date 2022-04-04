package com.example.presentation.repository

import com.example.common.mapper.Mapper
import com.example.domain.entity.User
import com.example.domain.repository.Repository
import com.example.presentation.model.UserDataModel
import com.example.presentation.source.LocalDataSource
import com.example.presentation.source.RemoteDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

//  local 부분 hilt module 작업해주기 (아직 미진행)
class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val userMapper : Mapper<UserDataModel, User>
) : Repository {

    // remote
    override fun getUsers(owner: String): Single<List<User>> {
        return remoteDataSource.getUsers(owner).map {
            it.map {
                userMapper.from(it)     // data -> domain
            }
        }
    }

    // local
    // 이 부분도 from / to Mapper 제대로 설정되었는지 확인해보기!
    override fun getLcoalUser(): Single<List<User>> {
        return localDataSource.getLcoalUser().map {
            it.map {
                userMapper.from(it)
            }
        }
    }

    override fun insertUser(userDataModel: User): Completable {
        return localDataSource.insertUser(userMapper.to(userDataModel))
    }

    override fun deleteUser(userDataModel: User): Completable {
        return localDataSource.deleteUser(userMapper.to(userDataModel))
    }
}