package com.example.mvi.first.presentation.sideeffect

import com.example.mvi.common.SideEffect
import com.example.mvi.first.domain.GeneratedText
import com.example.mvi.first.presentation.FirstScreenViewState

data class RefreshSuccessSideEffect(
    val generated: GeneratedText,
) : SideEffect<FirstScreenViewState>() {

    override fun newState(
        oldViewSate: FirstScreenViewState
    ) = oldViewSate.copy(
        content = generated.text,
        contentColor = generated.color,
        isRefreshLoading = false
    )

}