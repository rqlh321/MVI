package com.example.mvi.common

abstract class SideEffect<State : ViewState> {

    abstract fun newState(oldViewSate: State): State
}