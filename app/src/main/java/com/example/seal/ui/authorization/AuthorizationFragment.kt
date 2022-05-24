package com.example.seal.ui.authorization

import com.example.seal.databinding.FragmentAuthorizationBinding
import com.example.seal.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorizationFragment : BaseFragment<AuthorizationViewModel, FragmentAuthorizationBinding> (
    AuthorizationViewModel::class.java,
    { FragmentAuthorizationBinding.inflate(it) } ) {





}