package com.homanad.android.data.repository.boardAndTasks.datasource

import com.homanad.android.domain.entity.datamodel.BoardAndTasks

interface BoardAndTasksDataSource {
    suspend fun getAllBoardAndTasks(): List<BoardAndTasks>
    suspend fun getBoardAndTasksById(boardId: Long): BoardAndTasks
}