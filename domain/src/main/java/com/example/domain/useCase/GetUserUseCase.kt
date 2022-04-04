package com.example.domain.useCase

import com.example.domain.entity.User
import com.example.domain.repository.Repository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: Repository
) {
    fun execute(owner: String): Single<List<User>> =
        repository.getUsers(owner)
            .subscribeOn(Schedulers.io())
}