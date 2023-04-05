package com.example.mvi.first.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvi.common.EmptyOperationArgument
import com.example.mvi.first.presentation.event.FirstScreenEvent
import com.example.mvi.first.presentation.operation.FirstScreenOperation
import com.example.mvi.first.presentation.operation.NextActionArg
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor(
    private val channel: Channel<FirstScreenEvent>,
    val viewState: StateFlow<FirstScreenViewState>,
    private val initialSetupOperation: FirstScreenOperation.InitialSetup,
    private val nextActionClickedOperation: FirstScreenOperation.NextActionClicked,
    private val refreshOperation: FirstScreenOperation.Refresh,
) : ViewModel() {

    val events: Flow<FirstScreenEvent> = channel.receiveAsFlow()

    init {
        viewModelScope.launch {
            initialSetupOperation.execute(EmptyOperationArgument)
        }
    }

    fun onRetryButtonClick() {
        viewModelScope.launch {
            initialSetupOperation.execute(EmptyOperationArgument)
        }
    }

    fun onNexButtonClick(buttonHashCode: Int) {
        viewModelScope.launch {
            val args = NextActionArg(buttonHashCode)
            nextActionClickedOperation.execute(args)
        }
    }

    fun onPullToRefresh() {
        viewModelScope.launch {
            refreshOperation.execute(EmptyOperationArgument)
        }
    }
}