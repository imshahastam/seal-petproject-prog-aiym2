package com.example.seal.ui.register

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.seal.databinding.FragmentPersonalAccountBinding
import com.example.seal.databinding.FragmentRegisterBinding
import com.example.seal.ui.authorization.AuthorizationViewModel
import com.example.seal.ui.base.BaseFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<RegisterViewModel, FragmentRegisterBinding>(
    RegisterViewModel::class.java,
    { FragmentRegisterBinding.inflate(it) } ) {

    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email = binding.emailEditTxtRegister.text.toString()
        password = binding.passwordEditTxtRegister.text.toString()

        val name = binding.nameEditTxtRegister.text
        val surname = binding.surnameEditTxtRegister.text

        register()
    }

    private fun register() {
        if(email.isNotEmpty() && password.isNotEmpty()) {
            binding.registerBtn.setOnClickListener {
                viewModel.registerNewUser(email, password)
            }
        } else {
            Log.e("TAG", "empty")
        }
    }

}