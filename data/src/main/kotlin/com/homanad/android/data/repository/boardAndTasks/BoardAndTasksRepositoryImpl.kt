package com.homanad.android.data.repository.boardAndTasks

import com.homanad.android.data.repository.boardAndTasks.datasource.BoardAndTasksDataSource
import com.homanad.android.domain.entity.BoardAndTasks
import com.homanad.android.domain.repository.BoardAndTaskRepository
import javax.inject.Inject

class BoardAndTasksRepositoryImpl @Inject constructor(
    private val boardAndTasksDataSource: BoardAndTasksDataSource
) : BoardAndTaskRepository {

    override suspend fun getAllBoardAndTasks(): List<BoardAndTasks> {
        return boardAndTasksDataSource.getAllBoardAndTasks()
    }

    override suspend fun getBoardAndTasksById(boardId: Long): BoardAndTasks {
        return boardAndTasksDataSource.getBoardAndTasksById(boardId)
    }
}