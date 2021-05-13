package com.homanad.android.data.db.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.homanad.android.data.db.entity.BoardEntity
import com.homanad.android.data.db.entity.TaskEntity

data class TaskInBoardEntity(
    @Embedded
    val taskEntity: TaskEntity,
    @Relation(
        parentColumn = "boardId",
        entityColumn = "boardId",
    )
    val boardEntity: BoardEntity
)