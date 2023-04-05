package com.example.mvi.common

abstract class Operation<Arg : OperationArgument> {
    abstract suspend fun execute(arg: Arg)
}