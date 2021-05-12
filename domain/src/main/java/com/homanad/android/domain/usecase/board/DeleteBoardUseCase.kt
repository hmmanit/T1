package com.homanad.android.domain.usecase.board

import com.homanad.android.domain.common.UseCaseWithParam
import com.homanad.android.domain.entity.Board
import com.homanad.android.domain.repository.BoardRepository

class DeleteBoardUseCase(
    private val boardRepository: BoardRepository
) : UseCaseWithParam<Board, Int>() {

    override suspend fun create(param: Board): Int {
        return boardRepository.deleteBoard(param)
    }
}