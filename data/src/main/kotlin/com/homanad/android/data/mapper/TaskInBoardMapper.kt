package com.homanad.android.data.mapper

import com.homanad.android.data.db.entity.relation.TaskInBoardEntity
import com.homanad.android.domain.entity.datamodel.TaskInBoard

fun TaskInBoardEntity.toTaskInBoard() = TaskInBoard(
    taskEntity.taskId,
    taskEntity.boardId,
    taskEntity.taskTitle,
    taskEntity.taskDescription,
    taskEntity.priority,
    taskEntity.taskThemeColor,
    taskEntity.status,
    taskEntity.startTime,
    taskEntity.endTime,
    taskEntity.images,
    boardEntity.boardTitle
)