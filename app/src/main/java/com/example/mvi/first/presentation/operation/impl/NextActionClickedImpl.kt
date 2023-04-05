package com.example.mvi.first.presentation.operation.impl

import com.example.mvi.R
import com.example.mvi.first.domain.VisitsCountInteractor
import com.example.mvi.first.presentation.event.FirstScreenEvent
import com.example.mvi.first.presentation.operation.FirstScreenOperation
import com.example.mvi.first.presentation.operation.NextActionArg
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NextActionClickedImpl @Inject constructor(
    private val events: Channel<FirstScreenEvent>,
    private val interactor: VisitsCountInteractor,
) : FirstScreenOperation.NextActionClicked() {
    override suspend fun execute(arg: NextActionArg) {
        if (interactor.isFirstVisitOfSecondScreen()) {
            events.send(FirstScreenEvent.ShowSneck("We are on Second Screen at FIRST TIME!"))
        }
        events.send(FirstScreenEvent.NavigateTo(R.id.action_FirstFragment_to_SecondFragment))

    }
}