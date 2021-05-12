package com.homanad.android.domain.repository

import com.homanad.android.domain.entity.BoardAndTasks

interface BoardAndTaskRepository {
    suspend fun getAllBoardAndTasks(): List<BoardAndTasks>
    suspend fun getBoardAndTasksById(boardId: Long): BoardAndTasks
}