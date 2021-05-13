package com.homanad.android.data.mapper

import com.homanad.android.data.db.entity.BoardEntity
import com.homanad.android.domain.entity.Board

fun Board.toBoardEntity() = BoardEntity(boardId, boardTitle, boardDescription, boardImage)

fun BoardEntity.toBoard() = Board(boardId, boardTitle, boardDescription, boardImage)