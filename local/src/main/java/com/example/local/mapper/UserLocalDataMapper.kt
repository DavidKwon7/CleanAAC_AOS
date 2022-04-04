package com.example.local.mapper

import com.example.common.mapper.Mapper
import com.example.local.model.UserLocalModel
import com.example.presentation.model.UserDataModel
import javax.inject.Inject

class UserLocalDataMapper @Inject constructor(
) : Mapper<UserLocalModel, UserDataModel> {
    override fun from(i: UserLocalModel): UserDataModel {
        return UserDataModel(
            name = i.name,
            id = i.id,
            date = i.date,
            url = i.url
        )
    }

    override fun to(o: UserDataModel): UserLocalModel {
        return UserLocalModel(
            name = o.name,
            id = o.id,
            date = o.date,
            url = o.url
        )
    }
}