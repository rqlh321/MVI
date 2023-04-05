package com.example.mvi.first.presentation

import android.graphics.Color
import com.example.mvi.common.ViewState

data class FirstScreenViewState(
    val content: String? = null,
    val error: String? = null,
    val contentColor: Int = Color.TRANSPARENT,
    val isErrorVisible: Boolean = false,
    val isNextButtonVisible: Boolean = false,
    val isRetryButtonVisible: Boolean = false,
    val isInitialLoading: Boolean = false,
    val isRefreshLoading: Boolean = false,
    val isRefreshEnabled: Boolean = false,
) : ViewState()