package com.homanad.android.domain.usecase.boardAndTasks

import com.homanad.android.domain.common.UseCase
import com.homanad.android.domain.entity.datamodel.BoardAndTasks
import com.homanad.android.domain.repository.BoardAndTaskRepository

class GetAllBoardAndTasksUseCase(
    private val boardAndTaskRepository: BoardAndTaskRepository
) : UseCase<List<BoardAndTasks>>() {

    override suspend fun create(): List<BoardAndTasks> {
        return boardAndTaskRepository.getAllBoardAndTasks()
    }
}