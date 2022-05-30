package com.example.seal.ui.account

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.seal.R
import com.example.seal.databinding.FragmentPersonalAccountBinding
import com.example.seal.ui.FragmentListener
import com.example.seal.ui.authorization.AuthorizationFragment
import com.example.seal.ui.authorization.AuthorizationViewModel
import com.example.seal.ui.base.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonalAccountFragment : BaseFragment<PersonalAccountVM, FragmentPersonalAccountBinding>(
    PersonalAccountVM::class.java,
    { FragmentPersonalAccountBinding.inflate(it) } ) {

    lateinit var auth: FirebaseAuth
    private lateinit var fragmentListener: FragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListener = context as FragmentListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        menu.visibility = View.VISIBLE

        val user = auth.currentUser
        val email = user?.email

        binding.apply {
            userEmailTxt.text = email

            logoutBtn.setOnClickListener {
                fragmentListener.openFragment(AuthorizationFragment())
                Log.e("TAG", "accountFrg: logout")
            }
        }

    }
}