package com.example.mvi.first.domain

interface TextRepository {
    suspend fun text(): String
}