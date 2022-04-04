package com.example.domain.useCase

import com.example.domain.entity.User
import com.example.domain.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetLocalUserUseCase @Inject constructor(
    private val repository: Repository
) {
    fun execute(): Single<List<User>> {
        return repository.getLcoalUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}