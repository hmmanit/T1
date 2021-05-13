package com.homanad.android.domain.usecase.boardAndTasks

import com.homanad.android.domain.common.UseCaseWithParam
import com.homanad.android.domain.entity.datamodel.BoardAndTasks
import com.homanad.android.domain.repository.BoardRepository

class GetBoardAndTasksByIdUseCase(
    private val boardRepository: BoardRepository
) : UseCaseWithParam<Long, BoardAndTasks>() {

    override suspend fun create(param: Long): BoardAndTasks {
        return boardRepository.getBoardAndTasksById(param)
    }
}