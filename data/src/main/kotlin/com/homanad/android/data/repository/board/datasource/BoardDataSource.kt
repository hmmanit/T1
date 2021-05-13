package com.homanad.android.data.repository.board.datasource

import com.homanad.android.domain.entity.Board
import com.homanad.android.domain.entity.datamodel.BoardAndTasks

interface BoardDataSource {
    suspend fun createBoard(board: Board): Long
    suspend fun updateBoard(board: Board): Int
    suspend fun deleteBoard(board: Board): Int
    suspend fun getBoards(): List<Board>

    suspend fun getAllBoardAndTasks(): List<BoardAndTasks>
    suspend fun getBoardAndTasksById(boardId: Long): BoardAndTasks
}