package com.example.seal.ui.register

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.seal.databinding.FragmentPersonalAccountBinding
import com.example.seal.databinding.FragmentRegisterBinding
import com.example.seal.ui.authorization.AuthorizationViewModel
import com.example.seal.ui.base.BaseFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<RegisterViewModel, FragmentRegisterBinding>(
    RegisterViewModel::class.java,
    { FragmentRegisterBinding.inflate(it) } ) {

    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = binding.nameEditTxtRegister.text
        val surname = binding.surnameEditTxtRegister.text

        emailInputLayout = binding.textFieldRegister3
        passwordInputLayout = binding.textFieldRegister4

        binding.apply {

            registerBtn.setOnClickListener {
                val email = emailEditTxtRegister.text.toString()
                val password = passwordEditTxtRegister.text.toString()
                register(email, password)

                Log.e("TAG", "set email = $email, editTxt = $emailEditTxtRegister password = $password")
            }
        }
    }

    private fun register(email: String, password: String) {
        if(email.isNotEmpty() && password.isNotEmpty()) {
            viewModel.registerNewUser(email, password)
        } else {
            Log.e("TAG", "empty email and pswrd")
            emailInputLayout.error = "Введите почту!"
            passwordInputLayout.error = "Введите пароль!"
        }
    }

}