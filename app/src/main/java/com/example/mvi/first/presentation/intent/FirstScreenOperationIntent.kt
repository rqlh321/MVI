package com.example.mvi.first.presentation.intent

import com.example.mvi.common.OperationIntent

enum class FirstScreenOperationIntent : OperationIntent {
    INITIAL_LOADING,
    NEXT_BUTTON_CLICK,
    PULL_TO_REFRESH;
}
