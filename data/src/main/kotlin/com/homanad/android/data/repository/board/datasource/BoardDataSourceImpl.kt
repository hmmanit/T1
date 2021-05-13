package com.homanad.android.data.repository.board.datasource

import com.homanad.android.data.db.dao.BoardDAO
import com.homanad.android.data.mapper.toBoard
import com.homanad.android.data.mapper.toBoardEntity
import com.homanad.android.domain.entity.Board
import javax.inject.Inject

class BoardDataSourceImpl @Inject constructor(private val boardDAO: BoardDAO) : BoardDataSource {

    override suspend fun createBoard(board: Board): Long {
        return boardDAO.insert(board.toBoardEntity())
    }

    override suspend fun updateBoard(board: Board): Int {
        return boardDAO.update(board.toBoardEntity())
    }

    override suspend fun deleteBoard(board: Board): Int {
        return boardDAO.delete(board.toBoardEntity())
    }

    override suspend fun getBoards(): List<Board> {
        return boardDAO.getBoards().map { it.toBoard() }
    }
}