package com.example.mvi.first.domain

import javax.inject.Inject

class VisitsCountInteractorImpl @Inject constructor() : VisitsCountInteractor {

    private var visitsCount = 0

    override suspend fun isFirstVisitOfSecondScreen() = visitsCount == 0

    override suspend fun incSecondScreenVisits() {
        visitsCount += 1
    }


}