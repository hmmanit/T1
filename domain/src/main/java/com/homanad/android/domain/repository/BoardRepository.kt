package com.homanad.android.domain.repository

import com.homanad.android.domain.entity.Board

interface BoardRepository {
    suspend fun createBoard(board: Board): Long
    suspend fun updateBoard(board: Board): Int
    suspend fun deleteBoard(board: Board): Int
    suspend fun getBoards(): List<Board>
}