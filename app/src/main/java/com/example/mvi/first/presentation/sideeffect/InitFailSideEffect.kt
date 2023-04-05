package com.example.mvi.first.presentation.sideeffect

import com.example.mvi.common.SideEffect
import com.example.mvi.first.presentation.FirstScreenViewState

data class InitFailSideEffect(
    val failMessage: String
) : SideEffect<FirstScreenViewState>() {

    override fun newState(
        oldViewSate: FirstScreenViewState
    ) = oldViewSate.copy(
        error = failMessage,
        isErrorVisible = true,
        isRetryButtonVisible = true,
        isInitialLoading = false,
        isRefreshLoading = false,
        isNextButtonVisible = false,
        isRefreshEnabled = false,
    )

}