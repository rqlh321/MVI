package com.example.mvi.di

import com.example.mvi.common.OperationArgument
import com.example.mvi.first.presentation.FirstScreenViewState
import com.example.mvi.first.presentation.event.FirstScreenEvent
import com.example.mvi.first.presentation.intent.FirstScreenOperationIntent
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
import dagger.multibindings.IntoMap
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Module
@InstallIn(ViewModelComponent::class)
interface FirstScreenModule {

    @Binds
    @ViewModelScoped
    fun bindStateFlow(mutable: MutableStateFlow<FirstScreenViewState>): StateFlow<FirstScreenViewState>

    companion object {

        @Provides
        @IntoMap
        @OperationKey(FirstScreenOperationIntent.INITIAL_LOADING)
        @ViewModelScoped
        fun bindInitialSetup(impl: InitialSetupOperationImpl) = impl as FirstScreenOperation<OperationArgument>

        @Provides
        @IntoMap
        @OperationKey(FirstScreenOperationIntent.NEXT_BUTTON_CLICK)
        @ViewModelScoped
        fun bindNextActionClicked(impl: NextActionClickedImpl) = impl as FirstScreenOperation<OperationArgument>

        @Provides
        @IntoMap
        @OperationKey(FirstScreenOperationIntent.PULL_TO_REFRESH)
        @ViewModelScoped
        fun bindRefreshOperationImpl(impl: RefreshOperationImpl) = impl as FirstScreenOperation<OperationArgument>

        @Provides
        @ViewModelScoped
        fun provideMutableStateFlow() = MutableStateFlow(FirstScreenViewState())

        @Provides
        @ViewModelScoped
        fun provideChannel() = Channel<FirstScreenEvent>()
    }
}