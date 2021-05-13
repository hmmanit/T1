package com.homanad.android.data.db.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.homanad.android.data.db.entity.BoardEntity
import com.homanad.android.data.db.entity.TaskEntity

data class BoardAndTasksEntity(
    @Embedded
    val boardEntity: BoardEntity = BoardEntity(),
    @Relation(
        parentColumn = "boardId",
        entityColumn = "boardId"
    )
    val taskEntities: List<TaskEntity> = ArrayList()
)