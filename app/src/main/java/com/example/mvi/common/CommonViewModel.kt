package com.example.mvi.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class CommonViewModel<I : OperationIntent, O : Operation<OperationArgument>>(
    private val operations: Map<I, @JvmSuppressWildcards O>
) : ViewModel() {

    fun handleUserIntent(
        operationIntent: I,
        argument: OperationArgument = EmptyOperationArgument
    ) {
        viewModelScope.launch { operations[operationIntent]?.execute(argument) }
    }

}