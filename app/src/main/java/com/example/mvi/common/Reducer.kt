package com.example.mvi.common

import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class Reducer<VS : ViewState> @Inject constructor(
    private val mutable: MutableStateFlow<VS>
) {
    suspend fun reduce(effect: SideEffect<VS>) {
        val newState = effect.newState(mutable.value)
        mutable.emit(newState)
    }
}