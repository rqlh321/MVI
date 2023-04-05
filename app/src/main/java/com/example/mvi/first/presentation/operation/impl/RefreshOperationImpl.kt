package com.example.mvi.first.presentation.operation.impl

import com.example.mvi.common.EmptyOperationArgument
import com.example.mvi.common.Reducer
import com.example.mvi.first.domain.TextGenerationInteractor
import com.example.mvi.first.presentation.FirstScreenViewState
import com.example.mvi.first.presentation.event.FirstScreenEvent
import com.example.mvi.first.presentation.operation.FirstScreenOperation
import com.example.mvi.first.presentation.sideeffect.RefreshFailSideEffect
import com.example.mvi.first.presentation.sideeffect.RefreshLoadingSideEffect
import com.example.mvi.first.presentation.sideeffect.RefreshSuccessSideEffect
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class RefreshOperationImpl @Inject constructor(
    private val reducer: Reducer<FirstScreenViewState>,
    private val interactor: TextGenerationInteractor,
    private val events: Channel<FirstScreenEvent>,
) : FirstScreenOperation.Refresh() {

    override suspend fun execute(arg: EmptyOperationArgument) {
        try {
            reducer.reduce(RefreshLoadingSideEffect)
            val generatedText = interactor.generate()
            val effect = RefreshSuccessSideEffect(generatedText)
            reducer.reduce(effect)
        } catch (e: Exception) {
            events.send(FirstScreenEvent.ShowSneck("Refresh fail"))
            reducer.reduce(RefreshFailSideEffect)
        }
    }
}