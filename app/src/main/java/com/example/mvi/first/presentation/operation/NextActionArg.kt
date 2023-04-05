package com.example.mvi.first.presentation.operation

import com.example.mvi.common.OperationArgument

data class NextActionArg(
    val buttonHashCode: Int
) : OperationArgument()