package com.example.domain.repository

import com.example.domain.entity.User
import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getUsers(owner: String) : Single<List<User>>
}