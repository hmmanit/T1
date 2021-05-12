package com.homanad.android.domain.common

abstract class UseCaseWithParam<in P, out T> {

    suspend operator fun invoke(param: P): T = create(param)

    protected abstract suspend fun create(param: P): T
}