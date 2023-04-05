package com.example.mvi.first.presentation.sideeffect

import com.example.mvi.common.SideEffect
import com.example.mvi.first.presentation.FirstScreenViewState

object InitLoadingSideEffect : SideEffect<FirstScreenViewState>() {

    override fun newState(
        oldViewSate: FirstScreenViewState
    ) = oldViewSate.copy(
        isErrorVisible = false,
        isRetryButtonVisible = false,
        isInitialLoading = true,
        error = null,
        content = null,
        isRefreshLoading = false,
        isRefreshEnabled = false,
        isNextButtonVisible = false,
    )

}