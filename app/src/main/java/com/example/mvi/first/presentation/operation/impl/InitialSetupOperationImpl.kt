package com.example.mvi.first.presentation.operation.impl

import com.example.mvi.common.EmptyOperationArgument
import com.example.mvi.common.Reducer
import com.example.mvi.first.domain.FirstRequestBusinessException
import com.example.mvi.first.domain.TextGenerationInteractor
import com.example.mvi.first.presentation.FirstScreenViewState
import com.example.mvi.first.presentation.event.FirstScreenEvent
import com.example.mvi.first.presentation.operation.FirstScreenOperation
import com.example.mvi.first.presentation.sideeffect.InitFailSideEffect
import com.example.mvi.first.presentation.sideeffect.InitLoadingSideEffect
import com.example.mvi.first.presentation.sideeffect.InitSuccessSideEffect
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class InitialSetupOperationImpl @Inject constructor(
    private val events: Channel<FirstScreenEvent>,
    private val interactor: TextGenerationInteractor,
    private val reducer: Reducer<FirstScreenViewState>,
) : FirstScreenOperation.InitialSetup() {

    override suspend fun execute(arg: EmptyOperationArgument) {
        try {
            reducer.reduce(InitLoadingSideEffect)
            val generatedText = interactor.generate()
            val numbers = interactor.generate()
            val effect = InitSuccessSideEffect(generatedText,numbers)
            reducer.reduce(effect)
        } catch (e: FirstRequestBusinessException) {
            events.send(FirstScreenEvent.ShowSneck("Just try again"))
            val effect = InitFailSideEffect("Please retry!")
            reducer.reduce(effect)
        } catch (e: Exception) {
            val effect = InitFailSideEffect("Unknown Fail")
            reducer.reduce(effect)
        }
    }
}