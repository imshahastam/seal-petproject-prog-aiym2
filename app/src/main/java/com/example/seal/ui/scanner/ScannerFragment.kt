package com.example.seal.ui.scanner

import android.os.Bundle
import android.view.View
import com.example.seal.R
import com.example.seal.databinding.FragmentRegisterBinding
import com.example.seal.databinding.FragmentScannerBinding
import com.example.seal.ui.base.BaseFragment
import com.example.seal.ui.register.RegisterViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScannerFragment : BaseFragment<ScannerVM, FragmentScannerBinding>(
    ScannerVM::class.java,
    { FragmentScannerBinding.inflate(it) } ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        menu.visibility = View.VISIBLE
    }
}