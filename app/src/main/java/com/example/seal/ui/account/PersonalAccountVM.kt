package com.example.seal.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.seal.data.models.UserDto
import com.example.seal.domain.models.Cafe
import com.example.seal.ui.base.BaseViewModel
import com.example.seal.ui.base.LoadingEvent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonalAccountVM @Inject constructor() : BaseViewModel() {

//    private val _user = MutableLiveData<UserDto> ()
//    val user: LiveData<UserDto>
//        get() = _user

}