package com.example.seal.ui.register

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import com.example.seal.Event
import com.example.seal.R
import com.example.seal.data.models.UserDto
import com.example.seal.data.repo.UserRepo
import com.example.seal.domain.use_cases.SaveUserUseCase
import com.example.seal.ui.base.BaseEvent
import com.example.seal.ui.base.BaseViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val saveUserUseCase: SaveUserUseCase
) : BaseViewModel() {

    @SuppressLint("CheckResult")
    fun registerNewUser(email: String, password: String, name: String, surname: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    Log.e("TAG", "createUserWithEmail:success")
                    val user = auth.currentUser
                    val currentUserEmailAsId = user?.email

                    saveUserUseCase.invoke(UserDto(currentUserEmailAsId, name, surname, 0))
                        .subscribe({
                                   Log.e("TAG", "save user to backendless: success")
                        }, {
                            Log.e("TAG", "${it.message}")
                        })
                    val firebaseUser: FirebaseUser = task.result.user!!
                } else {
                    Log.e("TAG", "createUserWithEmail:failure", task.exception)
                    Event.ShowToast(R.string.authentication_failed)
                }
            }
    }
}