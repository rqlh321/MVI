package com.example.mvi.first.presentation.sideeffect

import com.example.mvi.common.SideEffect
import com.example.mvi.first.domain.GeneratedText
import com.example.mvi.first.presentation.FirstScreenViewState

data class InitSuccessSideEffect(
    val generated: GeneratedText,
    val qweqw: GeneratedText,
) : SideEffect<FirstScreenViewState>() {

    override fun newState(
        oldViewSate: FirstScreenViewState
    ) = oldViewSate.copy(
        content = generated.text,
        contentColor = generated.color,
        error = null,
        isErrorVisible = false,
        isRetryButtonVisible = false,
        isInitialLoading = false,
        isRefreshLoading = false,
        isRefreshEnabled = true,
        isNextButtonVisible = true,
    )

}