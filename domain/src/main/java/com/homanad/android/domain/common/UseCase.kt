package com.homanad.android.domain.common

abstract class UseCase<T> {

    suspend operator fun invoke(): T = create()

    protected abstract suspend fun create(): T
}