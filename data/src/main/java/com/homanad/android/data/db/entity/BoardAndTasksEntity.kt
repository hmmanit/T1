package com.homanad.android.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class BoardAndTasksEntity(
    @Embedded
    val boardEntity: BoardEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "boardId"
    )
    val taskEntities: List<TaskEntity>
)