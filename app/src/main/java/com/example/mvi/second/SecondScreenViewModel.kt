package com.example.mvi.second

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvi.first.domain.VisitsCountInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondScreenViewModel @Inject constructor(
    private val visitsCountInteractor: VisitsCountInteractor
) : ViewModel() {

    init {
        viewModelScope.launch {
            visitsCountInteractor.incSecondScreenVisits()
        }
    }
}