package com.example.seal.ui.account

import com.example.seal.databinding.FragmentPersonalAccountBinding
import com.example.seal.ui.authorization.AuthorizationViewModel
import com.example.seal.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonalAccountFragment : BaseFragment<AuthorizationViewModel, FragmentPersonalAccountBinding>(
    AuthorizationViewModel::class.java,
    { FragmentPersonalAccountBinding.inflate(it) } ) {
}