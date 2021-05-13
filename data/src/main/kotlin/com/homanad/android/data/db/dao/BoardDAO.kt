package com.homanad.android.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homanad.android.data.db.entity.BoardEntity
import com.homanad.android.data.common.BaseDao
import com.homanad.android.data.db.entity.relation.BoardAndTasksEntity

@Dao
abstract class BoardDAO : BaseDao<BoardEntity> {

    @Query("SELECT * FROM BoardEntity")
    abstract suspend fun getBoards(): List<BoardEntity>

    @Query("SELECT * FROM BoardEntity")
    abstract suspend fun getAllBoardAndTasks(): List<BoardAndTasksEntity>

    @Query("SELECT * FROM BoardEntity WHERE boardId = :boardId")
    abstract suspend fun getBoardAndTasksById(boardId: Long): BoardAndTasksEntity
}