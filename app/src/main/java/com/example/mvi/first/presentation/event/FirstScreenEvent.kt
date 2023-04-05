package com.example.mvi.first.presentation.event

import com.example.mvi.common.Event

sealed class FirstScreenEvent : Event() {
    data class NavigateTo(val screenId: Int) : FirstScreenEvent()
    data class ShowSneck(val text: String) : FirstScreenEvent()
}
