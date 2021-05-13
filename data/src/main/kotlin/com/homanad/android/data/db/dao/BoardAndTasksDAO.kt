package com.homanad.android.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homanad.android.data.db.entity.relation.BoardAndTasksEntity

@Dao
abstract class BoardAndTasksDAO {

    @Query("SELECT * FROM BoardEntity")
    abstract suspend fun getAllBoardAndTasks(): List<BoardAndTasksEntity>

    @Query("SELECT * FROM BoardEntity WHERE boardId = :boardId")
    abstract suspend fun getBoardAndTasksById(boardId: Long): BoardAndTasksEntity
}