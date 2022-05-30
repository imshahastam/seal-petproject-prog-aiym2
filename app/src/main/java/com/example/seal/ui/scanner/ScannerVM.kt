package com.example.seal.ui.scanner

import android.content.SharedPreferences
import android.util.Log
import com.example.seal.domain.use_cases.AddChequeToUserUseCase
import com.example.seal.ui.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScannerVM @Inject constructor(
//    private val addChequeToUserUseCase: AddChequeToUserUseCase,
//    private val getUserByIdFromApiUseCase: GetUserByIdFromApiUseCase,
    private val pref: SharedPreferences
) : BaseViewModel() {

    fun saveChequeSum(chequeSum: Int) {
        pref.edit().putInt("chequeSum", chequeSum).apply()
    }

    fun getChequeSum(savedChequeSumKey: String) : Int {
        return pref.getInt("chequeSum", 0) ?: 0
    }

    fun removeChequeSum() {
        pref.edit().clear().commit()
    }

//    fun addCheque(email: String, cheque: Int) {
//        addChequeToUserUseCase.invoke(email, cheque)
//        Log.e("TAG", "scanVM: put cheque to User")
//    }
//
//    fun getChequeSum(userId: String, chequeSum: Int) : Int {
//        getUserByIdFromApiUseCase.invoke(userId, chequeSum)
//        return pref.getInt("chequeSum", chequeSum)
//    }

}