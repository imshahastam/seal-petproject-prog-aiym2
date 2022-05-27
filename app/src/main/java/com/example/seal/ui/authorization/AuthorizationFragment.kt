package com.example.seal.ui.authorization

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.seal.databinding.FragmentAuthorizationBinding
import com.example.seal.ui.FragmentListener
import com.example.seal.ui.base.BaseFragment
import com.example.seal.ui.cafes.CafeListFragment
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorizationFragment : BaseFragment<AuthorizationViewModel, FragmentAuthorizationBinding> (
    AuthorizationViewModel::class.java,
    { FragmentAuthorizationBinding.inflate(it) } ), FragmentListener {

    private lateinit var fragmentListener: FragmentListener
    private lateinit var emailInputLayoutLogin: TextInputLayout
    private lateinit var passwordInputLayoutLogin: TextInputLayout

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListener = context as FragmentListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailInputLayoutLogin = binding.textFieldLogin
        passwordInputLayoutLogin = binding.textFieldLogin2

        binding.apply {
            loginBtn.setOnClickListener {
                val emailLogin = emailEditTxtLogin.text.toString()
                val passwordLogin = passwordEditTxtLogin.text.toString()

                login(emailLogin, passwordLogin)
                Log.e("TAG", "set email = $emailLogin, editTxt = $emailEditTxtLogin")
                fragmentListener.openFragment(CafeListFragment())
            }
        }
    }

    private fun login(email: String, password: String) {
        if(email.isNotEmpty() && password.isNotEmpty()) {
            viewModel.login(email, password)
        } else {
            Log.e("TAG", "empty email and pswrd")
            emailInputLayoutLogin.error = "Введите почту!"
            passwordInputLayoutLogin.error = "Введите пароль!"
        }
    }


}