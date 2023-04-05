package com.example.mvi.first.domain

interface VisitsCountInteractor {
    suspend fun isFirstVisitOfSecondScreen(): Boolean
    suspend fun incSecondScreenVisits()
}