package com.homanad.android.data.mapper

import com.homanad.android.data.db.entity.TaskEntity
import com.homanad.android.domain.entity.Task

fun Task.toTaskEntity() = TaskEntity(
    id,
    boardId,
    title,
    description,
    priority,
    themeColor,
    status,
    startTime,
    endTime,
    images
)

fun TaskEntity.toTask() = Task(
    id,
    boardId,
    title,
    description,
    priority,
    themeColor,
    status,
    startTime,
    endTime,
    images
)