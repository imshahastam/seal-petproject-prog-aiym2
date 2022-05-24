package com.example.seal.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

open class BaseFragment<viewModel: BaseViewModel, viewBinding: ViewBinding>(
    private val vmClass: Class<viewModel>,
    inline val bindingCreator: (inflater: LayoutInflater) -> viewBinding
): Fragment() {

    protected lateinit var viewModel: viewModel

    private var _binding: viewBinding? = null
    protected val binding: viewBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[vmClass]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingCreator(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}