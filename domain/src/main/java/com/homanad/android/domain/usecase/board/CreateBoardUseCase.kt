package com.homanad.android.domain.usecase.board

import com.homanad.android.domain.common.UseCaseWithParam
import com.homanad.android.domain.entity.Board
import com.homanad.android.domain.repository.BoardRepository

class CreateBoardUseCase(
    private val boardRepository: BoardRepository
) : UseCaseWithParam<Board, Long>() {

    override suspend fun create(param: Board): Long {
        return boardRepository.createBoard(param)
    }
}