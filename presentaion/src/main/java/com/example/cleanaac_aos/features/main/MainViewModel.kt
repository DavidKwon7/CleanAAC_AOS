package com.example.cleanaac_aos.features.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanaac_aos.model.UserPresentationModel
import com.example.common.mapper.Mapper
import com.example.domain.entity.User
import com.example.domain.useCase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

// baseViewModel 생성 후 compositeDisposable 처리해주기!

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val mapper: Mapper<UserPresentationModel, User>
) : ViewModel() {
    private val _getUser = MutableLiveData<List<UserPresentationModel>>()
    val getUser: LiveData<List<UserPresentationModel>>
        get() = _getUser

    fun getUsers(owner: String) {
        // map은 필요없나..?
        getUserUseCase.execute(owner)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _getUser.value = it.map { mapper.to(it) }
            }, {
                // error 처리 해주기
            })

    }
}