package com.homanad.android.data.repository.board

import com.homanad.android.data.repository.board.datasource.BoardDataSource
import com.homanad.android.domain.entity.Board
import com.homanad.android.domain.repository.BoardRepository
import javax.inject.Inject

class BoardRepositoryImpl @Inject constructor(
    private val boardDataSource: BoardDataSource
) : BoardRepository {

    override suspend fun createBoard(board: Board): Long {
        return boardDataSource.createBoard(board)
    }

    override suspend fun updateBoard(board: Board): Int {
        return updateBoard(board)
    }

    override suspend fun deleteBoard(board: Board): Int {
        return deleteBoard(board)
    }

    override suspend fun getBoards(): List<Board> {
        return getBoards()
    }
}