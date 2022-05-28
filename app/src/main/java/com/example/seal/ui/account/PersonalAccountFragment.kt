package com.example.seal.ui.account

import android.os.Bundle
import android.view.View
import com.example.seal.R
import com.example.seal.databinding.FragmentPersonalAccountBinding
import com.example.seal.ui.authorization.AuthorizationViewModel
import com.example.seal.ui.base.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonalAccountFragment : BaseFragment<AuthorizationViewModel, FragmentPersonalAccountBinding>(
    AuthorizationViewModel::class.java,
    { FragmentPersonalAccountBinding.inflate(it) } ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        menu.visibility = View.VISIBLE
    }
}