package com.homanad.android.data.repository.board

import com.homanad.android.data.repository.board.datasource.BoardDataSource
import com.homanad.android.domain.entity.Board
import com.homanad.android.domain.entity.datamodel.BoardAndTasks
import com.homanad.android.domain.repository.BoardRepository
import javax.inject.Inject

class BoardRepositoryImpl @Inject constructor(
    private val boardDataSource: BoardDataSource
) : BoardRepository {

    override suspend fun createBoard(board: Board): Long {
        return boardDataSource.createBoard(board)
    }

    override suspend fun updateBoard(board: Board): Int {
        return boardDataSource.updateBoard(board)
    }

    override suspend fun deleteBoard(board: Board): Int {
        return boardDataSource.deleteBoard(board)
    }

    override suspend fun getBoards(): List<Board> {
        return boardDataSource.getBoards()
    }

    override suspend fun getAllBoardAndTasks(): List<BoardAndTasks> {
        return boardDataSource.getAllBoardAndTasks()
    }

    override suspend fun getBoardAndTasksById(boardId: Long): BoardAndTasks {
        return boardDataSource.getBoardAndTasksById(boardId)
    }
}