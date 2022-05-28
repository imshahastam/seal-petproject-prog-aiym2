package com.example.seal.ui.cafes

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.seal.Event
import com.example.seal.R
import com.example.seal.data.models.CafeEntity
import com.example.seal.databinding.FragmentCafeListBinding
import com.example.seal.databinding.FragmentPersonalAccountBinding
import com.example.seal.domain.models.Cafe
import com.example.seal.ui.authorization.AuthorizationViewModel
import com.example.seal.ui.base.BaseFragment
import com.example.seal.ui.base.LoadingEvent
import com.example.seal.ui.cafes.recycler.CafeAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CafeListFragment : BaseFragment<CafeListVM, FragmentCafeListBinding>(
    CafeListVM::class.java,
    { FragmentCafeListBinding.inflate(it) } ) {

    private lateinit var cafeAdapter: CafeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cafeAdapter = CafeAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        menu.visibility = View.VISIBLE

        setupViews()
        subscribeToLiveData()
    }

    private fun setupViews() {
        val layoutManager = LinearLayoutManager(activity)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = cafeAdapter

        binding.swipe.setOnRefreshListener {
            viewModel.fetchCafe()
        }
    }

    private fun subscribeToLiveData() {
        viewModel.cafe.observe(viewLifecycleOwner) {
            it?.let {
                setDataToRecyclerView(it)
            }
        }

        viewModel.event.observe(viewLifecycleOwner) {
            when (it) {
                is LoadingEvent.ShowLoading -> binding.swipe.isRefreshing = true
                is LoadingEvent.StopLoading -> binding.swipe.isRefreshing = false
                else -> Log.e("DEBUG", getString(R.string.unknown_exception))
            }
        }
    }

    private fun setDataToRecyclerView(it: List<Cafe>) {
        it.let { cafeList ->
            cafeAdapter.setItems(cafeList)
        }
    }
}