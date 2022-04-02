package com.example.remote.api

import com.example.domain.entity.User
import com.example.presentation.model.UserDataModel
import com.example.remote.model.UserRemoteModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * github Api service
 */

interface ApiService {

    @GET("users/{owner}/repos")
    fun getRepos(@Path("owner") owner: String)
            : Single<List<UserRemoteModel>>
}