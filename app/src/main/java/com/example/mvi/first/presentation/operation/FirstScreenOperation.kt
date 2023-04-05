package com.example.mvi.first.presentation.operation

import com.example.mvi.common.EmptyOperationArgument
import com.example.mvi.common.Operation
import com.example.mvi.common.OperationArgument

sealed class FirstScreenOperation<Arg : OperationArgument> : Operation<Arg>() {
    abstract class InitialSetup : FirstScreenOperation<EmptyOperationArgument>()
    abstract class NextActionClicked : FirstScreenOperation<NextActionArg>()
    abstract class Refresh : FirstScreenOperation<EmptyOperationArgument>()
}

