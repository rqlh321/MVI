package com.example.mvi.di

import com.example.mvi.first.presentation.FirstScreenViewState
import com.example.mvi.first.presentation.event.FirstScreenEvent
import com.example.mvi.first.presentation.operation.FirstScreenOperation
import com.example.mvi.first.presentation.operation.impl.InitialSetupOperationImpl
import com.example.mvi.first.presentation.operation.impl.NextActionClickedImpl
import com.example.mvi.first.presentation.operation.impl.RefreshOperationImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Module
@InstallIn(ViewModelComponent::class)
interface FirstScreenModule {

    @Binds
    @ViewModelScoped
    fun bindInitialSetup(impl: InitialSetupOperationImpl): FirstScreenOperation.InitialSetup

    @Binds
    @ViewModelScoped
    fun bindNextActionClicked(impl: NextActionClickedImpl): FirstScreenOperation.NextActionClicked

    @Binds
    @ViewModelScoped
    fun bindRefreshOperationImpl(impl: RefreshOperationImpl): FirstScreenOperation.Refresh

    @Binds
    @ViewModelScoped
    fun bindStateFlow(mutable: MutableStateFlow<FirstScreenViewState>): StateFlow<FirstScreenViewState>

    companion object {

        @Provides
        @ViewModelScoped
        fun provideMutableStateFlow() = MutableStateFlow(FirstScreenViewState())

        @Provides
        @ViewModelScoped
        fun provideChannel() = Channel<FirstScreenEvent>()
    }
}