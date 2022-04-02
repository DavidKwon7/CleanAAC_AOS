package com.example.remote.mapper

import com.example.common.mapper.Mapper
import com.example.presentation.model.UserDataModel
import com.example.remote.model.UserRemoteModel
import javax.inject.Inject

class UserRemoteDataMapper @Inject constructor(
) : Mapper<UserRemoteModel, UserDataModel> {
    override fun from(i: UserRemoteModel): UserDataModel {
        return UserDataModel(
            i.name,
            i.id,
            i.date,
            i.url
        )
    }

    override fun to(o: UserDataModel): UserRemoteModel {
        return UserRemoteModel(
            name = o.name,
            id = o.id,
            date = o.date,
            url = o.url
        )
    }
}