package com.homanad.android.data.mapper

import com.homanad.android.data.db.entity.BoardEntity
import com.homanad.android.domain.entity.Board

fun Board.toBoardEntity() = BoardEntity(id, title, description, imagePath)

fun BoardEntity.toBoard() = Board(id, title, description, imagePath)