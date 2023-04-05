package com.example.mvi.di

import com.example.mvi.first.data.TextRepositoryImpl
import com.example.mvi.first.domain.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    @Singleton
    fun bindTextRepository(impl: TextRepositoryImpl): TextRepository

    @Binds
    @Singleton
    fun bindTextGenerationInteractor(impl: TextGenerationInteractorImpl): TextGenerationInteractor

    @Binds
    @Singleton
    fun bindVisitsCountInteractor(impl: VisitsCountInteractorImpl): VisitsCountInteractor

}