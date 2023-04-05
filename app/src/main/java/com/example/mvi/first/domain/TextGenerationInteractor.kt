package com.example.mvi.first.domain

interface TextGenerationInteractor {
    suspend fun generate(): GeneratedText
}