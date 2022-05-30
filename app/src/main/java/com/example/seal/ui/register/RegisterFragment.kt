package com.example.seal.ui.register

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.seal.R
import com.example.seal.databinding.FragmentPersonalAccountBinding
import com.example.seal.databinding.FragmentRegisterBinding
import com.example.seal.ui.FragmentListener
import com.example.seal.ui.authorization.AuthorizationFragment
import com.example.seal.ui.authorization.AuthorizationViewModel
import com.example.seal.ui.base.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
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
    private lateinit var nameInputLayout: TextInputLayout
    private lateinit var surnameInputLayout: TextInputLayout

    private lateinit var fragmentListener: FragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListener = context as FragmentListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        menu.visibility = View.GONE

        nameInputLayout = binding.textFieldRegister
        surnameInputLayout = binding.textFieldRegister2
        emailInputLayout = binding.textFieldRegister3
        passwordInputLayout = binding.textFieldRegister4

        binding.apply {

            registerBtn.setOnClickListener {
                val email = emailEditTxtRegister.text.toString()
                val password = passwordEditTxtRegister.text.toString()
                val name = nameEditTxtRegister.text.toString()
                val surname = surnameEditTxtRegister.text.toString()

                register(email, password, name, surname)

                Log.e("TAG", "set email = $email, name = $name password = $password")
            }

            loginBtn.setOnClickListener {
                fragmentListener.openFragment(AuthorizationFragment())
            }
        }
    }

    private fun register(email: String, password: String, name: String, surname: String) {
        if(email.isNotEmpty() && password.isNotEmpty()) {
            if(isItEmail(email) == true) {
                viewModel.registerNewUser(email, password, name, surname)
                Toast.makeText(requireActivity(), "Регистрация прошла успешно", Toast.LENGTH_LONG).show()
            } else {
                emailInputLayout.error = "Неверный формат почты"
            }
        } else {
            Log.e("TAG", "empty email and pswrd")
            emailInputLayout.error = "Введите почту!"
            passwordInputLayout.error = "Введите пароль!"
            nameInputLayout.error = "Введите имя!"
            surnameInputLayout.error = "Введите фамилию!"
        }
    }

    private fun isItEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}