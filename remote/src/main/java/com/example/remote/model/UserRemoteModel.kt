package com.example.remote.model

import android.os.Parcelable
import com.example.presentation.model.UserDataModel

//@Parcelize
data class UserRemoteModel(
    val name: String,
    val id: String,
    val date: String,
    val url: String
)  {
    // data module 의 data 와 연결
    companion object {
        fun toDataModel(
            remote: UserRemoteModel
        ): UserDataModel {
            return UserDataModel(
                name = remote.name,
                id = remote.id,
                date = remote.date,
                url = remote.url
            )
        }
    }
}
