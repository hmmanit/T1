package com.homanad.android.domain.usecase.board

import com.homanad.android.domain.common.UseCase
import com.homanad.android.domain.entity.Board
import com.homanad.android.domain.repository.BoardRepository

class GetBoardsUseCase(
    private val boardRepository: BoardRepository
) : UseCase<List<Board>>() {

    override suspend fun create(): List<Board> {
        return boardRepository.getBoards()
    }
}