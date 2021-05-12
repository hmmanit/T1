package com.homanad.android.domain.usecase.boardAndTasks

import com.homanad.android.domain.common.UseCaseWithParam
import com.homanad.android.domain.entity.BoardAndTasks
import com.homanad.android.domain.repository.BoardAndTaskRepository

class GetBoardAndTasksByIdUseCase(
    private val boardAndTaskRepository: BoardAndTaskRepository
) : UseCaseWithParam<Long, BoardAndTasks>() {

    override suspend fun create(param: Long): BoardAndTasks {
        return boardAndTaskRepository.getBoardAndTasksById(param)
    }
}