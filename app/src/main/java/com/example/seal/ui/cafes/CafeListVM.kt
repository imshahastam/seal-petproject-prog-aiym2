package com.example.seal.ui.cafes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.seal.Event
import com.example.seal.data.models.CafeEntity
import com.example.seal.domain.models.Cafe
import com.example.seal.domain.use_cases.GetCafeAsLiveDataUseCase
import com.example.seal.domain.use_cases.GetCafiesFromDBUseCase
import com.example.seal.domain.use_cases.GetCafiesUseCase
import com.example.seal.ui.base.BaseViewModel
import com.example.seal.ui.base.LoadingEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CafeListVM @Inject constructor(
    private val getCafiesUseCase: GetCafiesUseCase,
    private val getCafiesFromDB: GetCafiesFromDBUseCase
    ) : BaseViewModel() {

        private val _cafe = MutableLiveData<List<Cafe>> ()
        val cafe: LiveData<List<Cafe>>
            get() = _cafe

    init {
        fetchCafe()
    }

    fun fetchCafe() {
        _event.value = LoadingEvent.ShowLoading

        disposable.add(
            getCafiesUseCase()
                .doOnTerminate { _event.value = LoadingEvent.StopLoading  }
                .subscribe( {
                    _cafe.value = it
                }, this::handleError)
        )
    }

}