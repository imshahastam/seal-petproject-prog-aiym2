package com.example.seal.ui.register

import com.example.seal.databinding.FragmentPersonalAccountBinding
import com.example.seal.databinding.FragmentRegisterBinding
import com.example.seal.ui.authorization.AuthorizationViewModel
import com.example.seal.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<RegisterViewModel, FragmentRegisterBinding>(
    RegisterViewModel::class.java,
    { FragmentRegisterBinding.inflate(it) } ) {
}