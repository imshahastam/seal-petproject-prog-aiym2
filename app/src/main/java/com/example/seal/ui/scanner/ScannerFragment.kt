package com.example.seal.ui.scanner

import com.example.seal.databinding.FragmentRegisterBinding
import com.example.seal.databinding.FragmentScannerBinding
import com.example.seal.ui.base.BaseFragment
import com.example.seal.ui.register.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScannerFragment : BaseFragment<ScannerVM, FragmentScannerBinding>(
    ScannerVM::class.java,
    { FragmentScannerBinding.inflate(it) } ) {
}