package com.example.simpleproject.domain.usecases

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async

abstract class BaseUseCase<Params, Type> {

    abstract suspend fun execute(params: Params): Type

    operator fun invoke(
        scope: CoroutineScope,
        params: Params
    ) = scope.async {
        execute(params)
    }

    @Suppress("UNCHECKED_CAST")
    operator fun invoke(
        scope: CoroutineScope
    ) = scope.async {
        execute(None() as Params)
    }

    class None
}