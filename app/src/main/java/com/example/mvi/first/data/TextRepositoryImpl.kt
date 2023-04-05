package com.example.mvi.first.data

import com.example.mvi.first.domain.FirstRequestBusinessException
import com.example.mvi.first.domain.TextRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class TextRepositoryImpl @Inject constructor() : TextRepository {
    private var isFirstrequest = true

    override suspend fun text(): String {
        delay(2000)
        if (isFirstrequest) {
            isFirstrequest = false
            throw FirstRequestBusinessException()
        } else {
            return "Hola, ¿qué pasa?"
        }
    }
}