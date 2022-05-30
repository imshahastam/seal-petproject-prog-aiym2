package com.example.seal.ui.scanner

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.example.seal.R
import com.example.seal.databinding.FragmentScannerBinding
import com.example.seal.ui.base.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates

@AndroidEntryPoint
class ScannerFragment : BaseFragment<ScannerVM, FragmentScannerBinding>(
    ScannerVM::class.java,
    { FragmentScannerBinding.inflate(it) } ) {

    private lateinit var codeScanner: CodeScanner
    private var savedChequeSum by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedChequeSum = viewModel.getChequeSum("chequeSum")
        Log.e("TAG", "scanFrg onViewCreated: savedCheqSum - $savedChequeSum")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        menu.visibility = View.VISIBLE

        val scannerView = binding.scannerView
        val activity = requireActivity()
        var counter = savedChequeSum
        val countCoffeeTxt = binding.countCoffeeTxt

        countCoffeeTxt.text = savedChequeSum.toString()

        codeScanner = CodeScanner(activity, scannerView)

        codeScanner.decodeCallback = DecodeCallback {
            activity.runOnUiThread {
                val cheque = it.text.toString()
                counter += 1

                viewModel.saveChequeSum(counter)
                Log.e("TAG", "scanFrg: counter - $counter")

                val savedChequeSumNow = viewModel.getChequeSum("chequeSum")
                countCoffeeTxt.text = savedChequeSumNow.toString()
                Log.e("TAG", "scanFrg onViewCreated: savedCheqSum - $savedChequeSumNow")

            }
        }
        codeScanner.errorCallback = ErrorCallback {
            activity.runOnUiThread {
                Toast.makeText(activity, "Camera initialization error: ${it.message}",
                    Toast.LENGTH_LONG).show()
            }
        }
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }

//        binding.resetBtn.setOnClickListener {
//            viewModel.removeChequeSum()
//            Log.e("TAG", "reset - $savedChequeSum")
//        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}