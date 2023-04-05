package com.example.mvi.first.presentation.sideeffect

import com.example.mvi.common.SideEffect
import com.example.mvi.first.presentation.FirstScreenViewState

object RefreshLoadingSideEffect : SideEffect<FirstScreenViewState>() {

    override fun newState(
        oldViewSate: FirstScreenViewState
    ) = oldViewSate.copy(
        isRefreshLoading = true
    )

}