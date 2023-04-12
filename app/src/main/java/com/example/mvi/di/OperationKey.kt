package com.example.mvi.di

import com.example.mvi.first.presentation.intent.FirstScreenOperationIntent
import dagger.MapKey

@MapKey
annotation class OperationKey(val value: FirstScreenOperationIntent)