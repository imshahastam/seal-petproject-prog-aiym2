package com.example.seal.ui.register

import android.util.Log
import android.widget.Toast
import com.example.seal.Event
import com.example.seal.R
import com.example.seal.ui.base.BaseViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val auth: FirebaseAuth
) : BaseViewModel() {

//    private lateinit var auth: FirebaseAuth

    fun registerNewUser(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    Log.e("TAG", "createUserWithEmail:success")
                    val user = auth.currentUser
                } else {
                    Log.e("TAG", "createUserWithEmail:failure", task.exception)
                    Event.ShowToast(R.string.authentication_failed)
                }
            }
    }
}