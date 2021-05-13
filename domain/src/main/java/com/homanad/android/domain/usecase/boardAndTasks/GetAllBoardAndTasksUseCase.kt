package com.homanad.android.domain.usecase.boardAndTasks

import com.homanad.android.domain.common.UseCase
import com.homanad.android.domain.entity.datamodel.BoardAndTasks
import com.homanad.android.domain.repository.BoardRepository

class GetAllBoardAndTasksUseCase(
    private val boardRepository: BoardRepository
) : UseCase<List<BoardAndTasks>>() {

    override suspend fun create(): List<BoardAndTasks> {
        return boardRepository.getAllBoardAndTasks()
    }
}