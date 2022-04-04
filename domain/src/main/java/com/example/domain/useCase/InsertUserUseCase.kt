package com.example.domain.useCase

import com.example.domain.entity.User
import com.example.domain.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    private val repository: Repository
) {
    fun execute(user: User): Completable{
        return repository.insertUser(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}