package com.example.seal.ui.authorization

import android.app.Application
import android.text.TextUtils
import android.util.Log
import com.example.seal.ui.FragmentListener
import com.example.seal.ui.base.BaseViewModel
import com.example.seal.ui.cafes.CafeListFragment
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val auth: FirebaseAuth
) : BaseViewModel() {

    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.e("TAG", "loginUserWithEmail:success")
                } else {
                    Log.e("TAG", "loginUserWithEmail:failed")
                }
            }
    }
}