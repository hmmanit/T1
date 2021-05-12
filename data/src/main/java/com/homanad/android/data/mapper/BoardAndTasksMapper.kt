package com.homanad.android.data.mapper

import com.homanad.android.data.db.entity.BoardAndTasksEntity
import com.homanad.android.domain.entity.BoardAndTasks

fun BoardAndTasks.toBoardAndTasksEntity() =
    BoardAndTasksEntity(board.toBoardEntity(), tasks.map { it.toTaskEntity() })

fun BoardAndTasksEntity.toBoardAndTasks() =
    BoardAndTasks(boardEntity.toBoard(), taskEntities.map { it.toTask() })