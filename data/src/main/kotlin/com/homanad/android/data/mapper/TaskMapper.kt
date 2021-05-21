package com.homanad.android.data.mapper

import com.homanad.android.data.db.entity.TaskEntity
import com.homanad.android.domain.entity.Task

fun Task.toTaskEntity() = TaskEntity(
    taskId,
    boardId,
    taskTitle,
    taskDescription,
    priority,
    taskThemeColor,
    status,
    startTime,
    endTime,
    images
)

fun TaskEntity.toTask() = Task(
    taskId,
    boardId,
    taskTitle,
    taskDescription,
    priority,
    taskThemeColor,
    status,
    startTime,
    endTime,
    images
)