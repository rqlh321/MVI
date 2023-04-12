package com.example.mvi.first.presentation

import com.example.mvi.common.CommonViewModel
import com.example.mvi.common.OperationArgument
import com.example.mvi.first.presentation.event.FirstScreenEvent
import com.example.mvi.first.presentation.intent.FirstScreenOperationIntent
import com.example.mvi.first.presentation.operation.FirstScreenOperation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor(
    val viewState: StateFlow<FirstScreenViewState>,
    channel: Channel<FirstScreenEvent>,
    operations: Map<FirstScreenOperationIntent, @JvmSuppressWildcards FirstScreenOperation<OperationArgument>>,
) : CommonViewModel<FirstScreenOperationIntent, FirstScreenOperation<OperationArgument>>(operations) {

    val events: Flow<FirstScreenEvent> = channel.receiveAsFlow()

    init {
        handleUserIntent(FirstScreenOperationIntent.INITIAL_LOADING)
    }

}